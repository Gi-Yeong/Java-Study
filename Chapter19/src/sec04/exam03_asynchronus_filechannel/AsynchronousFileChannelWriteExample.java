package sec04.exam03_asynchronus_filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynchronousFileChannelWriteExample {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 10; i++) {
            Path path = Paths.get("F:/Temp/file" + i + ".txt");
            Files.createDirectories(path.getParent());

            // 비동기 파일 채널 생성
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                    path,
                    EnumSet.of(StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING),
                    executorService);

            Charset charset = Charset.defaultCharset();
            String data = "안녕하세요 김기영입니다";
            ByteBuffer byteBuffer = charset.encode(data);

            // 첨부 객체 생성
            class Attachment {
                Path path;
                AsynchronousFileChannel fileChannel;
            }

            Attachment attachment = new Attachment();
            attachment.path = path;
            attachment.fileChannel = fileChannel;

            // CompletionHandler 객체 생성
            CompletionHandler<Integer, Attachment> completionHandler = new CompletionHandler<Integer, Attachment>() {
                @Override
                public void completed(Integer result, Attachment attachment) {
                    System.out.println("파일 이름 : " + attachment.path.getFileName() + " : " + result + " bytes written : " + Thread.currentThread().getName());
                    try {
                        attachment.fileChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Throwable exc, Attachment attachment) {
                    exc.printStackTrace();
                    try {
                        attachment.fileChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            fileChannel.write(byteBuffer, 0, attachment, completionHandler);
        }

        // 쓰레드 풀 종료
        executorService.shutdown();
    }
}

package sec04.exam02_file_copy;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileCopyExample {

    public static void main(String[] args) throws Exception {
        Path from = Paths.get("F:/Temp/choa.gif");
        Path to = Paths.get("F:/Temp/choa1.gif");

        FileChannel fileChannel_from = FileChannel.open(from, StandardOpenOption.READ);
        FileChannel fileChannel_to = FileChannel.open(to, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        int byteCount;
        while (true) {
            byteBuffer.clear();
            byteCount = fileChannel_from.read(byteBuffer);
            if (byteCount == -1) break;

            byteBuffer.flip();
            fileChannel_to.write(byteBuffer);
        }

        fileChannel_from.close();
        fileChannel_to.close();
        System.out.println("복사 완료");
    }
}

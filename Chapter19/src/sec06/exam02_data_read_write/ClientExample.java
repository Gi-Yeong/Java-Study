package sec06.exam02_data_read_write;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ClientExample {

    public static void main(String[] args) {
        SocketChannel socketChannel = null;

        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(true);
            System.out.println("[연결 요청]");
            socketChannel.connect(new InetSocketAddress("localhost", 5001));

            System.out.println("[연결 성공]");

            ByteBuffer byteBuffer;
            Charset charset = Charset.forName(String.valueOf(StandardCharsets.UTF_8));

            String data = "안녕하세요";

            byteBuffer = charset.encode(data);
            socketChannel.write(byteBuffer);
            System.out.println("[데이터 보내기 성공]");

            byteBuffer = ByteBuffer.allocate(100);
            int byteCount = socketChannel.read(byteBuffer);
            byteBuffer.flip();
            String message = charset.decode(byteBuffer).toString();
            System.out.println("[데이터 받기 성공] : " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (socketChannel.isOpen()) {
            try {
                socketChannel.close();
            } catch (IOException e) {}
        }
    }
}

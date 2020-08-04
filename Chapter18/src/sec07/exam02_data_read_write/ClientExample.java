package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientExample {

    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket();
            System.out.println("[연결 요청]");
            socket.connect(new InetSocketAddress("localhost", 5001));
            System.out.println("[연결 성공]");

            byte[] bytes = null;
            OutputStream os = socket.getOutputStream();

            String message = "남현준 바보";
            bytes = message.getBytes(StandardCharsets.UTF_8);
            
            os.write(bytes);
            os.flush();
            System.out.println("[데이터 보내기 성공]");

            InputStream is = socket.getInputStream();
            bytes = new byte[100];
            int readDataCount = is.read(bytes);
            message = new String(bytes, 0, readDataCount, StandardCharsets.UTF_8);
            System.out.println("[데이터 받기 성공] : " + message);

            os.close();
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

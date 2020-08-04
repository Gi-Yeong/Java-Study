package training;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerExample {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost", 5001));

        System.out.println("[서버 시작]");

        while (true) {
            try {
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();

                byte[] bytes = new byte[512];
                int readByteCount = -1;

                inputStream.read(bytes, 0, 100);
                String fileName = new String(bytes, 0, 100, StandardCharsets.UTF_8);
                fileName = fileName.trim();

                System.out.println("[파일 받기 시작]" + fileName);

                FileOutputStream fileOutputStream = new FileOutputStream("F:/Temp/Dir/" + fileName);
                while ((readByteCount = inputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, readByteCount);
                }
                fileOutputStream.flush();

                System.out.println("[파일 받기 완료]");

                fileOutputStream.close();
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                break;
            }
        }
    }
}

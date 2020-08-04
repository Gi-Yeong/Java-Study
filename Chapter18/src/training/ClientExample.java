package training;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ClientExample {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5001);
        OutputStream outputStream = socket.getOutputStream();

        String filePath = "F:/Temp/choa.gif";
        File file = new File(filePath);

        String fileName = file.getName();
        byte[] fileNameBytes = fileName.getBytes(StandardCharsets.UTF_8);
        fileNameBytes = Arrays.copyOf(fileNameBytes, 100);
        outputStream.write(fileNameBytes);

        System.out.println("[파일 보내기 시작]" + fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[512];
        int readByteCount = -1;
        while ((readByteCount = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, readByteCount);
        }

        outputStream.flush();
        System.out.println("[파일 보내기 완료]");

        fileInputStream.close();
        outputStream.close();
        socket.close();
    }
}

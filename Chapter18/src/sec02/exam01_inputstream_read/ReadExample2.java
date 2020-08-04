package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample2 {

    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("F:/Temp/test.txt")) {
            int readByteNo;
            byte[] readBytes = new byte[3];
            StringBuilder data = new StringBuilder();

            while (true) {
                readByteNo = is.read(readBytes);
                if (readByteNo == -1) break;
                data.append(new String(readBytes, 0, readByteNo));
            }
            System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

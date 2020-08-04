package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample3 {

    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("F:/Temp/test.txt")) {
            int readByteNo;
            byte[] readBytes = new byte[8];
            readByteNo = is.read(readBytes, 2, 3);

            for (byte readByte : readBytes) {
                System.out.println(readByte);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

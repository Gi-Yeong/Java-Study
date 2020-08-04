package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample1 {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new FileInputStream("F:/Temp/test.txt");
            int readByte;

            while ((readByte = is.read()) != -1) {
                System.out.println((char) readByte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

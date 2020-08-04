package sec04.exam03_fileoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamExample {

    public static void main(String[] args) throws Exception {
        String originalFileName = "F:/Temp/choa.gif";
        String targetFileName = "F:/Temp/house.gif";

        FileInputStream fis = new FileInputStream(originalFileName);
        FileOutputStream fos = new FileOutputStream(targetFileName);

        int readByteNo;
        byte[] readBytes = new byte[100];

        while ((readByteNo = fis.read(readBytes)) != -1) {
            fos.write(readBytes, 0, readByteNo);
        }
        fos.flush();

        fos.close();
        fis.close();

        System.out.println("복사 완료");
    }
}

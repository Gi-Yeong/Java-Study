package sec05.exam03_bufferedinputstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamExample {

    public static void main(String[] args) throws Exception {
        long start = 0;
        long end = 0;

        FileInputStream fis1 = new FileInputStream("F:/Temp/choa.gif");
        start = System.currentTimeMillis();
        while (fis1.read() != -1) {}
        end = System.currentTimeMillis();
        System.out.println("사용 하지 않았을 때: " + (end - start) + " ms");
        fis1.close();

        FileInputStream fis2 = new FileInputStream("F:/Temp/choa.gif");
        BufferedInputStream bis = new BufferedInputStream(fis2);

        start = System.currentTimeMillis();
        while (bis.read() != -1) {}
        end = System.currentTimeMillis();
        System.out.println("사용 했을 때: " + (end - start) + " ms");
        bis.close();
        fis2.close();
    }
}

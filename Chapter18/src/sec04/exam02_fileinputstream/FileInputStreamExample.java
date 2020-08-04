package sec04.exam02_fileinputstream;

import java.io.FileInputStream;

public class FileInputStreamExample {

    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("F:/Study/This is Java/Chapter18/src/sec04/exam02_fileinputstream/FileInputStreamExample.java");
        int data;
        while ((data = fis.read()) != -1) {
            System.out.write(data);
        }
        System.out.flush();
        fis.close();
    }
}

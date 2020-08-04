package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample3 {

    public static void main(String[] args) {
        try (Reader reader = new FileReader("F:/Temp/test.txt")) {
            int readCharNo;
            char[] cbuf = new char[4];

            readCharNo = reader.read(cbuf, 1, 2);
            System.out.println(cbuf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

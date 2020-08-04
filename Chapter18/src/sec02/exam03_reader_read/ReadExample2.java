package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample2 {

    public static void main(String[] args) {
        try (Reader reader = new FileReader("F:/Temp/test.txt")) {
            int readCharNo;
            char[] cbuf = new char[2];
            StringBuilder data = new StringBuilder();

            while ((readCharNo = reader.read(cbuf)) != -1) {
                System.out.println(readCharNo);
                data.append(new String(cbuf, 0, readCharNo));
            }
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

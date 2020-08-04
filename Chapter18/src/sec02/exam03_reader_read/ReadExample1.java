package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample1 {

    public static void main(String[] args) {
        try (Reader reader = new FileReader("F:/Temp/test.txt")) {
            int readData;
            while ((readData = reader.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

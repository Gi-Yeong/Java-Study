package sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample1 {

    public static void main(String[] args) {
        try (Writer writer = new FileWriter("F:/Temp/test.txt")){
            char[] data = "홍길동".toCharArray();

            for (char datum : data) {
                writer.write(datum);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

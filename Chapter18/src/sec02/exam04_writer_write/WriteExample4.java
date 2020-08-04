package sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample4 {

    public static void main(String[] args) {
        try (Writer writer = new FileWriter("F:/Temp/test.txt")){
            String str = "안녕 자바 프로그램";

            writer.write(str, 3, 2);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

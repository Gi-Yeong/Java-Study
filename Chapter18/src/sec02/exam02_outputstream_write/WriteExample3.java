package sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample3 {

    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("F:/Temp/test.txt")) {
            byte[] data = "ABC".getBytes();
            os.write(data, 1, 2);
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

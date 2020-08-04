package sec03.exam01_system_in_out;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class SystemOutExample1 {

    public static void main(String[] args) {
        OutputStream os = System.out;

        try {
            for (byte b = 48; b < 58 ; b++) {
               os.write(b);
            }

            os.write(10);

            for (byte b = 97; b < 123; b++) {
                os.write(b);
            }

            os.write(10);

            String hangul = "가나다라마바사아자차카타파하";
            byte[] hangulBytes = hangul.getBytes();
            os.write(hangulBytes);

            os.flush();

            String a = System.lineSeparator();
            System.out.println(Arrays.toString(a.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package sec03.exam01_system_in_out;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample2 {

    public static void main(String[] args) {
        InputStream is = System.in;

        byte[] datas = new byte[15];

        try {
            System.out.print("이름을 입력 하세요 : ");
            int nameBytes = is.read(datas);
            String name = new String(datas, 0, nameBytes - 1);

            System.out.print("하고 싶은말 : ");
            int commentBytes = is.read(datas);
            String comment = new String(datas, 0, commentBytes - 1);

            System.out.println(name);
            System.out.println(comment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

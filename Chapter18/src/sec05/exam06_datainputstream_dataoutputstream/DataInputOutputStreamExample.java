package sec05.exam06_datainputstream_dataoutputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamExample {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("F:/Temp/primitive.dat");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("김기영");
        dos.writeDouble(95.5);
        dos.writeInt(10);

        dos.writeUTF("남현준");
        dos.writeDouble(95.2);
        dos.writeInt(20);

        dos.flush();
        dos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("F:/Temp/primitive.dat");
        DataInputStream dis = new DataInputStream(fis);

        for (int i = 0; i < 2; i++) {
            String name = dis.readUTF();
            double dou = dis.readDouble();
            int intData = dis.readInt();

            System.out.println(name);
            System.out.println(dou);
            System.out.println(intData);
        }

        dis.close();
        fis.close();
    }
}

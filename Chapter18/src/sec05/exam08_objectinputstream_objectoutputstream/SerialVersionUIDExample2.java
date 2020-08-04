package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerialVersionUIDExample2 {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("F:/Temp/UIDSample.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ClassC classC = (ClassC) ois.readObject();
        int field1 = classC.field1;
        System.out.println(field1);

        ois.close();
        fis.close();
    }
}

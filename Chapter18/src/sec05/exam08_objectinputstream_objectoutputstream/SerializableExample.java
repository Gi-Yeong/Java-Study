package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableExample {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("F:/Temp/Serializable.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        ClassA classA = new ClassA();
        classA.field1 = 1;
        classA.field2.field1 = 2;
        ClassA.field3 = 3;
        classA.field4 = 4;

        oos.writeObject(classA);
        oos.flush();
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("F:/Temp/Serializable.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ClassA v = (ClassA) ois.readObject();
        System.out.println(v.field1);
        System.out.println(v.field2.field1);
        System.out.println(v.field3);
        System.out.println(v.field4);
    }
}

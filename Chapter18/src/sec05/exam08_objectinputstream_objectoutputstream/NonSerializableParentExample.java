package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NonSerializableParentExample {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("F:/Temp/Object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Child child = new Child();
        child.field1 = "아이";
        child.field2 = "부모";

        oos.writeObject(child);
        oos.flush();
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("F:/Temp/Object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Child readChild = (Child) ois.readObject();
        System.out.println(readChild.field1);
        System.out.println(readChild.field2);

        ois.close();
        fis.close();
    }
}

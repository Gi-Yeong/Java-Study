package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamExample {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("F:/Temp/Object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(new Integer(100));
        oos.writeObject(new Double(3.14));
        oos.writeObject(new int[] {1, 2, 3});
        oos.writeObject(new String("김기영"));

        oos.flush();
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("F:/Temp/Object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Integer obj1 = (Integer) ois.readObject();
        Double obj2 = (Double) ois.readObject();
        int[] obj3 = (int[]) ois.readObject();
        String obj4 = (String) ois.readObject();

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.print(obj3[0] + "," + obj3[1] + "," + obj3[2]);
        System.out.println();
        System.out.println(obj4);

        ois.close();
        fis.close();
    }
}

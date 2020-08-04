package sec03.exam02_Byteorder;

import java.nio.ByteOrder;

public class ComputerByteOrderExample {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(ByteOrder.nativeOrder());
    }
}

package sec07.exam01_constructor;

import java.io.IOException;

public class KeyboardToStringExample {

    public static void main(String[] args) {
        byte[] bytes = new byte[100];

        System.out.print("입력: ");
        try {
            int readByteNo = System.in.read(bytes);
            String str = new String(bytes, 0, readByteNo - 1);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

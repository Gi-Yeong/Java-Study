package sec07.exam02_method;

import java.io.UnsupportedEncodingException;

public class StringGetByteExample {

    public static void main(String[] args) {
        String str = "안녕하세요";

        byte[] bytes1 = str.getBytes();
        System.out.println("bytes1.length: " + bytes1.length);

        String str1 = new String(bytes1);
        System.out.println("bytes1 -> str: " + str1);

        try {
            byte[] bytes2 = str.getBytes("EUC-KR");
            System.out.println("bytes2.length: " + bytes2.length);

            String str2 = new String(bytes2, "EUC-KR");
            System.out.println("bytes2 -> str2: " + str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

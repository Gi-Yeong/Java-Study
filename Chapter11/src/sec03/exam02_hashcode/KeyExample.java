package sec03.exam02_hashcode;

import java.util.HashMap;

public class KeyExample {

    public static void main(String[] args) {
        HashMap<Key, String> hashMap = new HashMap<>();

        hashMap.put(new Key(1), "홍길동");

        String value = hashMap.get(new Key(1));
        System.out.println(value);
    }
}

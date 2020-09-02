package sec07.exam02_method;

public class StringValueOfExample {

    public static void main(String[] args) {
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(10.5);
        String str3 = String.valueOf(true);

        // 해당 값은 문자열 이다. "10", "10.5", "true"
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}

package sec07.exam02_method;

public class StringToLowerUpperCaseExample {

    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = "JAVA Programming";

        System.out.println(str1.equals(str2));

        System.out.println(str1.toLowerCase().equals(str2.toLowerCase()));

        System.out.println(str1.equalsIgnoreCase(str2));
    }
}

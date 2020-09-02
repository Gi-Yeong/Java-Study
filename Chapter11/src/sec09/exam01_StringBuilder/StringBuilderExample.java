package sec09.exam01_StringBuilder;

public class StringBuilderExample {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Java ");
        stringBuilder.append("Program Study");
        System.out.println(stringBuilder.toString());

        stringBuilder.insert(4, 2);
        System.out.println(stringBuilder.toString());

        stringBuilder.setCharAt(4, '6');
        System.out.println(stringBuilder.toString());

        stringBuilder.replace(6, 13, "Book");
        System.out.println(stringBuilder.toString());

        stringBuilder.delete(4, 5);
        System.out.println(stringBuilder.toString());

        int length = stringBuilder.length();
        System.out.println("총 문자수: " + length);

        String result = stringBuilder.toString();
        System.out.println(result);
    }
}

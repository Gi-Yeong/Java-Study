package sec08.exam01_split_stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample {

    public static void main(String[] args) {
        String text = "홍길동/이수형/박연수";

        StringTokenizer st = new StringTokenizer(text, "/");

        int countTokens = st.countTokens();
        System.out.println(countTokens);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}

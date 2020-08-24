package sec05.exam01_treeset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample3 {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("apple");
        treeSet.add("forever");
        treeSet.add("description");
        treeSet.add("ever");
        treeSet.add("zoo");
        treeSet.add("base");
        treeSet.add("guess");
        treeSet.add("cherry");

        System.out.println("[C~F 사이의 단어 검색]");
        NavigableSet<String> strings = treeSet.subSet("c", true, "f", true);
        for (String word :
                strings) {
            System.out.println(word);
        }
    }
}

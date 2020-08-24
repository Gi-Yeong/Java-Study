package sec05.exam02_treemap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapExample3 {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("apple", 10);
        treeMap.put("forever", 60);
        treeMap.put("description", 40);
        treeMap.put("ever", 50);
        treeMap.put("zoo", 10);
        treeMap.put("base", 70);
        treeMap.put("guess", 30);
        treeMap.put("cherry", 50);

        System.out.println("c~f 사이의 단어 검색");

        NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "f", true);
        for (Map.Entry<String, Integer> entry :
                rangeMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue() + "페이지");
        }
    }
}

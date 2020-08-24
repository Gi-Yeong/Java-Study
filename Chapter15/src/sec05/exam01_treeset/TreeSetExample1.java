package sec05.exam01_treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample1 {

    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();

        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);

        Integer score = null;

        score = scores.first();
        System.out.println("가장 낮은 점수: " + score);
        System.out.println();

        score = scores.last();
        System.out.println("가장 높은 점수: " + score);

        score = scores.lower(95);
        System.out.println("95 아래 점수: " + score);

        score = scores.higher(95);
        System.out.println("95 위에 점수: " + score);

        score = scores.floor(95);
        System.out.println("95 이거나 바로 아래 점수: " + score);
        
        score = scores.ceiling(85);
        System.out.println("85 이거나 바로 위에 점수: " + score);

        System.out.println();
        while (!scores.isEmpty()) {
            score = scores.pollLast(); // TreeSet 에서 객체를 가져오고 해당 객체는 TreeSet 에서 제거
            System.out.println(score + "(남은 객체수 : " + scores.size() + ")");
        }

        /*Iterator<Integer> integerIterator = scores.iterator();
        while (integerIterator.hasNext()) {
            int s = integerIterator.next(); // TreeSet 에서 값을 가져오지만 TreeSet 에서 제거 하지는 않는다. 제거 하려면 다음에 바로 integerIterator.remove() 해야 한다.
            System.out.println(s);
        }*/
    }
}

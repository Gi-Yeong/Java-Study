package sec06.stream_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {

    public static void main(String[] args) {
        IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
        intStream.boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println();

        IntStream intStream1 = Arrays.stream(new int[] {5, 3, 2, 1, 4});
        intStream1.sorted()
                .forEach(System.out::println);
        System.out.println();

        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 30),
                new Student("신용권", 10),
                new Student("유미선", 20)
        );

        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s.getScore() + ","));
    }
}

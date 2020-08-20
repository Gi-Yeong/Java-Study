package sec11.stream_collect;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListExample {

    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("홍길동", 10, Student.Sex.MALE),
                new Student("김수애", 6, Student.Sex.FEMALE),
                new Student("신용권", 10, Student.Sex.MALE),
                new Student("박수미", 6, Student.Sex.FEMALE)
        );

        // 남학생들만 묶어 List 생성
        List<Student> maleList = totalList.stream()
                .filter(n -> n.getSex() == Student.Sex.MALE)
                .collect(Collectors.toList());
        maleList.forEach(s -> System.out.println(s.getName()));

        System.out.println();

        // 여학생들만 묶어 HashSet 생성
        Set<Student> femaleSet = totalList.stream()
                .filter(s -> s.getSex() == Student.Sex.FEMALE)
                .collect(Collectors.toCollection(HashSet::new));
        femaleSet.forEach(s -> System.out.println(s.getName()));

        System.out.println();

        // Hashset::new 부분을 풀어 쓰면 아래
        Set<Student> femaleSet1 = totalList.stream()
                .filter(s -> s.getSex() == Student.Sex.FEMALE)
                .collect(Collectors.toCollection(() ->{
                    HashSet<Student> hashSet = new HashSet<>();
                    return hashSet;
                }));
        femaleSet1.forEach(s -> System.out.println(s.getName()));
    }
}

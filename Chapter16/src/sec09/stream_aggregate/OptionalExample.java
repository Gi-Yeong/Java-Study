package sec09.stream_aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

//        double avg = list.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .getAsDouble();

        OptionalDouble optionalDouble = list.stream()
                .mapToInt(Integer::intValue)
                .average();
        if (optionalDouble.isPresent()) {
            System.out.println("평균1 : " + optionalDouble.getAsDouble());
        } else {
            System.out.println("평균1 : " + 0.0);
        }

        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("평균2 : " + avg);

        list.add(3);
        list.add(4);
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a -> System.out.println("평균3 : " + a));

    }
}

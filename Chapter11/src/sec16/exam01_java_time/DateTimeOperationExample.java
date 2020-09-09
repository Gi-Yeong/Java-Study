package sec16.exam01_java_time;

import java.time.LocalDateTime;

public class DateTimeOperationExample {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime targetDateTime = now
                .plusYears(1)
                .plusMonths(2)
                .plusDays(3)
                .plusHours(4)
                .minusMinutes(5)
                .plusSeconds(6);
        System.out.println(targetDateTime);
    }
}

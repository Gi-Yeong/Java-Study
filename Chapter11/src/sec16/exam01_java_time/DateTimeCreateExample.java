package sec16.exam01_java_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimeCreateExample {

    public static void main(String[] args) {
        // 날짜 얻기
        LocalDate currDate = LocalDate.now();
        System.out.println(currDate);

        LocalDate targetDate = LocalDate.of(2024, 5, 10);
        System.out.println(targetDate);

        // 시간 얻기
        LocalTime currTime=  LocalTime.now();
        System.out.println(currTime);

        LocalTime targetTime = LocalTime.of(6, 30, 0, 0);
        System.out.println(targetTime);

        // 날짜와 시간 얻기
        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println(currDateTime);

        LocalDateTime targetDateTime = LocalDateTime.of(2024, 5, 10, 6, 30, 0, 0);
        System.out.println(targetDateTime);

        // 협정 세계시와 시간존(TimeZone)
        ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(utcDateTime);

        ZonedDateTime newyorkDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(newyorkDateTime);


       /*String[] availableIds = TimeZone.getAvailableIDs();
        for (String zone : availableIds) {
            System.out.println(zone);
        }*/

        // 특정 시점의 타임 스탬프 얻기
        Instant instant1 = Instant.now();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();
        if (instant1.isBefore(instant2)) {
            System.out.println("instant1이 빠릅니다.");
        } else if (instant1.isAfter(instant2)) {
            System.out.println("instant1이 늦습니다.");
        } else {
            System.out.println("동일한 시간입니다.");
        }
        System.out.println("차이(nanos): " + instant1.until(instant2, ChronoUnit.NANOS));
    }
}

package sec05.exam07_andthen_compose;

import java.util.function.Function;

public class FunctionAndThenComposeExample {

    public static void main(String[] args) {
        Function<Member, Address> functionA;
        Function<Address, String> functionB;
        Function<Member, String> functionAB;

        functionA = member -> member.getAddress();
        functionB = address -> address.getCity();

        functionAB = functionA.andThen(functionB);

        String city = functionAB.apply(new Member("홍길동", "hong", new Address("한국", "서울")));
        System.out.println("거주 도시: " + city);

        functionAB = functionB.compose(functionA);

        city = functionAB.apply(new Member("홍길동", "hong", new Address("한국", "서울")));
        System.out.println("거주 도시: " + city);
    }
}

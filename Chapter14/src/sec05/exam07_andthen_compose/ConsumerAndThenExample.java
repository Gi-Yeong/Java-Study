package sec05.exam07_andthen_compose;

import java.util.function.Consumer;

public class ConsumerAndThenExample {

    public static void main(String[] args) {
        Consumer<Member> consumerA = (member -> {
            System.out.println("consumerA:" + member.getName());
        });

        Consumer<Member> consumerB = (member -> {
            System.out.println("consumerB:" + member.getId());
        });

        Consumer<Member> consumerAB = consumerA.andThen(consumerB);
        consumerAB.accept(new Member("홍길동", "hong", null));
    }
}

package sec03.exam01_equals;

public class MemberExample {

    public static void main(String[] args) {
        Member obj1 = new Member("Blue");
        Member obj2 = new Member("Blue");
        Member obj3 = new Member("Red");

        if (obj1.equals(obj2)) {
            System.out.println("obj1과 obj2 는 동등합니다.");
        } else {
            System.out.println("obj1과 obj2 는 다릅니다.");
        }

        if (obj1 == obj2) {
            System.out.println("obj1과 obj2 는 동등합니다.");
        } else {
            System.out.println("obj1과 obj2 는 다릅니다.");
        }

        if (obj1.equals(obj3)) {
            System.out.println("obj1과 obj3 는 동등합니다.");
        } else {
            System.out.println("obj1과 obj3 는 다릅니다.");
        }
    }
}

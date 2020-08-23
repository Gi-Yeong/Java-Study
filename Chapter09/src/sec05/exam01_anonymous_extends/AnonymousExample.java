package sec05.exam01_anonymous_extends;

public class AnonymousExample {

    public static void main(String[] args) {
        Anonymous anonymous = new Anonymous();
        anonymous.field.wake();
        anonymous.method1();
        anonymous.method2(new Person() {
            String studentNo;
            void run() {
                System.out.println("조깅 합니다.");
            }

            @Override
            void wake() {
                System.out.println("8시에 일어납니다.");
                run();
            }
        });
    }
}

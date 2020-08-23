package sec05.exam02_anonymous_implements;

public class AnonymousExample {

    public static void main(String[] args) {
        Anonymous anonymous = new Anonymous();
        anonymous.remoteControl.turnOn();
        anonymous.remoteControl.turnOff();

        anonymous.method1();

        anonymous.method2(new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("스마트 티비를 켭니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("스마트 티비를 끕니다.");
            }
        });
    }
}

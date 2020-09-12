package sec10.exam03_static_be_careful;

public class Car {
    int speed;

    void run() {
        System.out.println(speed + "로 달립니다.");
    }

    public static void main(String[] args) {
        /*speed = 60; 이건 안된다.
        run();*/

        Car car = new Car();
        car.speed = 60;
        car.run();
    }
}

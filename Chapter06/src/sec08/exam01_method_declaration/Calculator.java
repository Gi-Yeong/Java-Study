package sec08.exam01_method_declaration;

public class Calculator {

    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    int plus(int x, int y) {
        return x + y;
    }

    double divide(int x, int y) {
        return (double) x / (double) y;
    }
}

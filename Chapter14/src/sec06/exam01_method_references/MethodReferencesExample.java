package sec06.exam01_method_references;

import java.util.function.IntBinaryOperator;

public class MethodReferencesExample {

    public static void main(String[] args) {
        IntBinaryOperator operator;

        // 정적 메소드 참조
        operator = (x, y) -> Calculator.staticMethod(x, y);
        System.out.println(operator.applyAsInt(1, 2));

        operator = Calculator::staticMethod;
        System.out.println(operator.applyAsInt(3, 4));

        // 인스턴스 메소드 참조
        Calculator obj = new Calculator();
        operator = (x, y) -> obj.instanceMethod(x, y);
        System.out.println(operator.applyAsInt(5, 6));

        operator = obj::instanceMethod;
        System.out.println(operator.applyAsInt(7, 8));
    }
}

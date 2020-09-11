package sec08.exam01_method_declaration;

public class Computer {
    public int sum1(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public int sum2(int ... values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}

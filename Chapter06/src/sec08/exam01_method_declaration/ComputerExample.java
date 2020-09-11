package sec08.exam01_method_declaration;

public class ComputerExample {

    public static void main(String[] args) {
        Computer computer = new Computer();

        int[] values1 = {1, 2, 3};
        int result1 = computer.sum1(values1);
        System.out.println(result1);

        int result2 = computer.sum1(new int[] {1, 2, 3});
        System.out.println(result2);

        int result3 = computer.sum2(1, 2, 3);
        System.out.println(result3);


        int result4 = computer.sum2(1, 2, 3, 5, 6);
        System.out.println(result4);
    }
}

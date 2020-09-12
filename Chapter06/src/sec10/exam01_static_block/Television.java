package sec10.exam01_static_block;

public class Television {
    static String company = "Samsung";
    static String model = "LCD";
    static String info;
    static int from1to10Sum;

    static {
        info = company + "-" + model;

        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        from1to10Sum = sum;
    }
}

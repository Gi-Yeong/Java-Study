package sec03.exam03_return;

public class MyFunctionalInterfaceExample {

    public static void main(String[] args) {
        MyFunctionalInterFace fi;

        fi = (x, y) -> {
            int result = x + y;
            return result;
        };

        System.out.println(fi.method(2,5));

        fi = (x, y) -> x + y;
        System.out.println(fi.method(2,5));

        fi = Integer::sum;
        System.out.println(fi.method(2,5));

        fi = (x, y) -> sum(x, y);
        System.out.println(fi.method(5, 3));

        fi = MyFunctionalInterfaceExample::sum;
        System.out.println(fi.method(5, 3));
    }

    public static int sum(int x, int y) {
        return (x + y);
    }
}

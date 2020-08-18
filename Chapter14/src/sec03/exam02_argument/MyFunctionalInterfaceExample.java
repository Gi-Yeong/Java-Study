package sec03.exam02_argument;

public class MyFunctionalInterfaceExample {

    public static void main(String[] args) {
        MyFunctionalInterFace fi;

        fi = x -> {
            int result = x * 5;
            System.out.println(result);
        };
        fi.method(3);

        fi = x -> System.out.println(x * 5);
        fi.method(3);
    }
}

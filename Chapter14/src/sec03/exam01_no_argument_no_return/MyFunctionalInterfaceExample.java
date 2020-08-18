package sec03.exam01_no_argument_no_return;

public class MyFunctionalInterfaceExample {

    public static void main(String[] args) {
        MyFunctionalInterFace fi;

        fi = () -> {
            String str = "method Call1";
            System.out.println(str);
        };
        fi.method();

        fi = () -> System.out.println("method Call2");
        fi.method();

        fi = new MyFunctionalInterFace() {
            @Override
            public void method() {
                System.out.println("method call3");
            }
        };

        fi.method();
    }
}

package sec04.exam01_field;

public class UsingThis {
    public int outterfield = 10;

    class Inner {
        int innerfield = 20;

        void method() {
            MyFunctionalInterface fi = () -> {
                System.out.println("outerField:" + outterfield);
                System.out.println("outerField:" + UsingThis.this.outterfield);
                System.out.println("innerField:" + innerfield);
                System.out.println("innerField:" + this.innerfield);
            };
            fi.method();
        }
    }
}

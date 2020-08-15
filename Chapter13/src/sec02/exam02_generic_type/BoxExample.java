package sec02.exam02_generic_type;

public class BoxExample {

    public static void main(String[] args) {
        Box<String> box1 = new Box<>();

        box1.setT("hello");
        String greet = box1.getT();

        Box<Integer> box2 = new Box<>();
        box2.setT(3);
        int value = box2.getT();
    }
}

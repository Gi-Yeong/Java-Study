package sec04.exam01_generic_method;

public class Util {

    public static <T> Box<T> boxing(T t){
        Box<T> box = new Box<>();
        box.setT(t);

        return box;
    }
}

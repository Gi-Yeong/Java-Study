package sec06.exam07_array_copy;

public class ArrayCopyExample {

    public static void main(String[] args) {
        String[] oldStrArray = {"java", "array", "copy"};
        String[] newStrArray = new String[5];

        System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);

        for (String name :
                newStrArray) {
            System.out.print(name + ", ");
        }
    }
}

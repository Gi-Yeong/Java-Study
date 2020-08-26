package sec03.exam02_hashcode;

public class Key {
    public int number;

    public Key(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals");
        if (obj instanceof Key) {
            Key compareKey = (Key) obj;
            return this.number == compareKey.number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        return number;
    }
}

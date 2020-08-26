package sec03.exam06_finalize;

public class FinalizeExample {

    public static void main(String[] args) {
        Counter counter = null;
        for (int i = 0; i < 50; i++) {
            counter = new Counter(i);
            counter = null;
            System.gc(); // 호출 한다고 다 바로 호출 된다는 보장이 없다.
        }
    }
}

package sec02.exam01_createthread;

public class BeepPrintExample3 {

    public static void main(String[] args) {
        // how1
        Thread thread = new BeepThread();
        thread.start();

        // "띵" 문자열을 5번 출력하는 작업
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

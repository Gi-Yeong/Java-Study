package sec06.exam06_stop;

public class PrintThread2 extends Thread {

    @Override
    public void run() {
/*        try {
            while (true) {
                System.out.println("실행 중");
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {}*/

        do {
            System.out.println("실행 중");
        } while (!isInterrupted()); //
//        } while (!Thread.interrupted()); //isInterrupted()

        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}

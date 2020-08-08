package sec05.exam01_state;

public class StatePrintThread extends Thread {
    private TargetThread targetThread;

    public StatePrintThread(TargetThread targetThread) {
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        while (true) {
            Thread.State state = targetThread.getState();
            System.out.println("타겟 스레드 상태 : " + state);
            
            if (state == Thread.State.NEW) {
                targetThread.start();
            }

            if (state == Thread.State.TERMINATED) {
                break;
            }


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}

package sec07.exam01_daemon;

public class DaemonExample {

    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("메인 스레드 종료");
    }
}

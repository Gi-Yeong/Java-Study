package sec08.exam01_threadgroup;

public class ThreadGroupExample {

    public static void main(String[] args) {
        ThreadGroup myGroup = new ThreadGroup("myGroup"); // main thread 에서 ThreadGroup 이 실행 되기 때문에, main thread group 아래 myGroup 이 생긴다.
        WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
        WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");

        workThreadA.start();
        workThreadB.start();

        System.out.println("[ main 스레드 그룹의 list() 메소드 출력 내용 ]");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        mainGroup.list();
        System.out.println();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[ myGroup 스레드 그룹의 interrupt() 메소드 호출 ]");
        myGroup.interrupt();
    }
}

package sec06.exam03_join;

public class JoinExample {

    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join(); // sumThread 의 run()이 끝날 때 까지 기다린다. sumThread 를 실행하는 main Thread 가 일시 정지 된다.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("1~100 합: " + sumThread.getSum());
    }
}

package sec09.exam01_excute_submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteVsSubmitExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                int poolSize = threadPoolExecutor.getPoolSize();
                String threadName = Thread.currentThread().getName();
                System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);
                int value = Integer.parseInt("삼");
            };
//            executorService.execute(runnable); // 처리중에 에러가 나면 해당 Thread 를 제거 하고 새로 생성함.
            executorService.submit(runnable); // 처리중에 에러가 나면 Thread 를 재 사용함.
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        executorService.shutdown();
    }
}

package sec09.exam02_blocking;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println("[작업 처리 요청]");

        Runnable runnable = () -> {
            int sum = 0;
            for (int i = 0; i <= 10; i++) {
                sum += i;
            }
            System.out.println("[처리 결과] " + sum);
        };

        Future future = executorService.submit(runnable);
        try {
            future.get();
            System.out.println("[작업 처리 완료]");
        } catch (InterruptedException e) {
            System.out.println("[예외 발생 함]" + e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("[예외 발생 함]" + e.getMessage());
        }

        executorService.shutdown();
    }
}

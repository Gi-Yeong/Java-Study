package sec09.exam02_blocking;

import java.util.concurrent.*;

public class CompletionServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        System.out.println("[작업 처리 요청]");
        for (int i = 0; i < 30; i++) {
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() {
                    int sum = 0;
                    for (int j = 1; j <= 10; j++) {
                        sum += j;
                    }
                    return sum;
                }
            });
        }

        System.out.println("[처리 완료된 작업 확인]");
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Future<Integer> future = completionService.take();
                        int value = future.get();

                        System.out.println("[처리 결과] " + value);
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }
}

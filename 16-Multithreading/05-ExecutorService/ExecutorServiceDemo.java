import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // ExecutorService manages a pool of threads for you, instead of
        // manually creating and starting Thread objects yourself.
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // submit() runs a Runnable task using the pool
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
            });
        }

        // submit() can also run a Callable, which RETURNS a result via a Future
        Callable<Integer> sumTask = () -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) sum += i;
            return sum;
        };

        Future<Integer> future = executor.submit(sumTask);
        System.out.println("Sum of 1 to 100 = " + future.get()); // blocks until the result is ready

        // Always shut down the executor when you're done with it
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Executor shut down. All tasks complete: " + executor.isTerminated());
    }
}

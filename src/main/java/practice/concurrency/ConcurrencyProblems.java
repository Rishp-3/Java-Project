package practice.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/** Module 16 - Multithreading: threads, synchronization, ExecutorService, Callable/Future. */
public final class ConcurrencyProblems {
    private ConcurrencyProblems() {}

    /** Problem 1: sum an array by splitting it across a fixed thread pool. */
    public static long parallelSum(int[] data, int threads) throws InterruptedException, ExecutionException {
        if (threads < 1) throw new IllegalArgumentException("threads must be >= 1");
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        try {
            List<Future<Long>> parts = new ArrayList<>();
            int chunk = (data.length + threads - 1) / threads;
            for (int start = 0; start < data.length; start += Math.max(chunk, 1)) {
                final int from = start, to = Math.min(start + chunk, data.length);
                parts.add(pool.submit(() -> {
                    long s = 0;
                    for (int i = from; i < to; i++) s += data[i];
                    return s;
                }));
            }
            long total = 0;
            for (Future<Long> f : parts) total += f.get();
            return total;
        } finally {
            pool.shutdown();
        }
    }

    /** Problem 2: a counter that is safe to increment from many threads (synchronized). */
    public static class SafeCounter {
        private int value;
        public synchronized void increment() { value++; }
        public synchronized int get() { return value; }
    }

    /** Runs the given task on N threads, each repeating it M times, and waits for them all. */
    public static void hammer(Runnable task, int threads, int timesEach) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int t = 0; t < threads; t++) {
            Thread th = new Thread(() -> { for (int i = 0; i < timesEach; i++) task.run(); });
            list.add(th);
            th.start();
        }
        for (Thread th : list) th.join();
    }

    /** Problem 3: the same idea with a lock-free AtomicInteger. */
    public static int atomicCount(int threads, int timesEach) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        hammer(counter::incrementAndGet, threads, timesEach);
        return counter.get();
    }

    /** Problem 4: run many Callables concurrently and collect results IN SUBMISSION ORDER. */
    public static <T> List<T> runAll(List<Callable<T>> tasks) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(Math.max(1, Math.min(tasks.size(), 4)));
        try {
            List<T> results = new ArrayList<>();
            for (Future<T> f : pool.invokeAll(tasks)) results.add(f.get());
            return results;
        } finally {
            pool.shutdown();
        }
    }
}

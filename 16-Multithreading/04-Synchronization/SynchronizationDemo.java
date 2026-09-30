public class SynchronizationDemo {

    // Without synchronization, multiple threads updating shared data at the
    // same time can cause a "race condition" and produce wrong results.
    static class Counter {
        private int count = 0;

        // 'synchronized' ensures only ONE thread can execute this method
        // on this object at a time, preventing race conditions.
        synchronized void increment() {
            count++;
        }

        int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // With synchronization, this will always correctly print 2000
        System.out.println("Final count (synchronized): " + counter.getCount());

        // Synchronized block - locks only the critical section, not the whole method
        Object lock = new Object();
        int[] shared = {0};

        Runnable blockTask = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    shared[0]++;
                }
            }
        };

        Thread t3 = new Thread(blockTask);
        Thread t4 = new Thread(blockTask);
        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("Final count (synchronized block): " + shared[0]);
    }
}

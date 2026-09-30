public class ThreadDemo {

    // Way 1: extend the Thread class and override run()
    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " - count " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts: " + Thread.currentThread().getName());

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("Thread-A");
        t2.setName("Thread-B");

        t1.start(); // starts a NEW thread that runs concurrently with main
        t2.start();

        // join() makes the main thread wait until t1 and t2 finish
        t1.join();
        t2.join();

        System.out.println("Main thread ends after both threads finish.");

        // Note: calling run() directly (t1.run()) would just run it like
        // a normal method on the current thread - start() is what actually
        // creates a new thread of execution.
    }
}

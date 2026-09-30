public class RunnableDemo {

    // Way 2: implement Runnable (preferred - Java doesn't support multiple
    // inheritance, so implementing an interface leaves the class free to
    // extend something else too).
    static class Task implements Runnable {
        private final String taskName;

        Task(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(taskName + " - step " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = new Task("Download");
        Runnable task2 = new Task("Upload");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Runnable also works great with lambda expressions (functional interface)
        Runnable lambdaTask = () -> System.out.println("Running via a lambda Runnable!");
        new Thread(lambdaTask).start();
    }
}

public class ThreadMethodsDemo {

    static class Worker extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " (priority " + getPriority() + ") - " + i);
                try {
                    Thread.sleep(100); // pause this thread for 100 milliseconds
                } catch (InterruptedException e) {
                    System.out.println(getName() + " was interrupted!");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker w1 = new Worker();
        Worker w2 = new Worker();

        w1.setName("Worker-1");
        w2.setName("Worker-2");

        w1.setPriority(Thread.MAX_PRIORITY); // hint to the scheduler (not guaranteed)
        w2.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Is w1 alive before start? " + w1.isAlive());

        w1.start();
        w2.start();

        System.out.println("Is w1 alive after start? " + w1.isAlive());
        System.out.println("Is w1 a daemon thread? " + w1.isDaemon());

        w1.join(); // wait for w1 to finish
        w2.join(); // wait for w2 to finish

        System.out.println("Is w1 alive after join? " + w1.isAlive());
        System.out.println("All work finished.");
    }
}

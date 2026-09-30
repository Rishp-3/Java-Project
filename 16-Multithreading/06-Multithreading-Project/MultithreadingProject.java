import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// Mini project: simulate multiple bank tellers processing deposits into one
// shared account concurrently, safely, using synchronization + an ExecutorService.
public class MultithreadingProject {

    static class BankAccount {
        private double balance;

        BankAccount(double balance) {
            this.balance = balance;
        }

        synchronized void deposit(double amount) {
            double newBalance = balance + amount;
            balance = newBalance;
        }

        synchronized double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(0);
        AtomicInteger transactionsProcessed = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Simulate 100 deposits of 10 each coming from 4 "tellers" concurrently
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                account.deposit(10);
                transactionsProcessed.incrementAndGet();
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Transactions processed: " + transactionsProcessed.get());
        System.out.println("Final balance: " + account.getBalance() + " (expected 1000.0)");
    }
}

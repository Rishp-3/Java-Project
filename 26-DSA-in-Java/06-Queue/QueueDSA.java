import java.util.LinkedList;
import java.util.Queue;

public class QueueDSA {

    // A Queue is naturally used for BFS (Breadth-First Search) style processing.
    // Here: simulate a simple ticket counter serving customers in FIFO order.
    static void simulateTicketCounter() {
        Queue<String> customers = new LinkedList<>();
        customers.offer("Customer 1");
        customers.offer("Customer 2");
        customers.offer("Customer 3");

        while (!customers.isEmpty()) {
            System.out.println("Serving: " + customers.poll());
        }
    }

    // Generate binary numbers from 1 to n using a Queue
    static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            String front = queue.poll();
            System.out.println(front);
            queue.offer(front + "0");
            queue.offer(front + "1");
        }
    }

    // Implement a Queue using two Stacks (a classic interview question)
    static class QueueUsingStacks {
        java.util.Deque<Integer> inStack = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> outStack = new java.util.ArrayDeque<>();

        void enqueue(int value) {
            inStack.push(value);
        }

        int dequeue() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }
    }

    public static void main(String[] args) {
        simulateTicketCounter();

        System.out.println("\nFirst 5 binary numbers:");
        generateBinaryNumbers(5);

        System.out.println("\nQueue using two stacks:");
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
    }
}

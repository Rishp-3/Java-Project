import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {

        // Queue: FIFO (First-In-First-Out) data structure
        Queue<String> printQueue = new LinkedList<>();
        printQueue.offer("Document1");
        printQueue.offer("Document2");
        printQueue.offer("Document3");

        System.out.println("Queue: " + printQueue);
        System.out.println("Peek (next to process): " + printQueue.peek());

        while (!printQueue.isEmpty()) {
            System.out.println("Processing: " + printQueue.poll());
        }

        // PriorityQueue: elements come out in priority order, not insertion order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);
        minHeap.offer(5);

        System.out.println("\nPriorityQueue (min-heap) polling order:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // always the smallest remaining
        }

        // Max-heap using a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(java.util.List.of(30, 10, 20, 5));
        System.out.println("\nMax-heap polling order:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {

        // Deque (Double Ended Queue): insert/remove from BOTH ends
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);

        System.out.println("Deque: " + deque); // [0, 1, 2, 3]

        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());

        deque.removeFirst();
        deque.removeLast();
        System.out.println("After removing both ends: " + deque);

        // Using Deque as a Stack (LIFO) - push/pop work on the front
        Deque<String> stack = new ArrayDeque<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("\nStack (via Deque): " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack);

        // Using Deque as a Queue (FIFO)
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("First");
        queue.offer("Second");
        System.out.println("\nQueue (via Deque): " + queue);
        System.out.println("Poll: " + queue.poll());
    }
}

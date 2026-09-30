import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        // LinkedList: a doubly-linked list. Fast insert/remove at the ends,
        // slower random access compared to ArrayList.
        LinkedList<String> tasks = new LinkedList<>();

        tasks.add("Write code");
        tasks.add("Test code");
        tasks.addFirst("Plan project");   // add to the front
        tasks.addLast("Deploy");          // add to the end

        System.out.println("Tasks: " + tasks);
        System.out.println("First: " + tasks.getFirst());
        System.out.println("Last: " + tasks.getLast());

        tasks.removeFirst();
        System.out.println("After removeFirst: " + tasks);

        // LinkedList can also be used as a Queue (FIFO) ...
        tasks.offer("Review code"); // adds to the end
        System.out.println("Peek (front): " + tasks.peek());
        System.out.println("Poll (removes front): " + tasks.poll());
        System.out.println("After poll: " + tasks);

        // ... or as a Stack (LIFO)
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack);
    }
}

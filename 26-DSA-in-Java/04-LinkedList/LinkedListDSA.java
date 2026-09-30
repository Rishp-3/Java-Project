public class LinkedListDSA {

    // A hand-built singly linked list (as taught in DSA courses), unlike java.util.LinkedList
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static class LinkedList {
        Node head;

        void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        void reverse() {
            Node prev = null, current = head;
            while (current != null) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }

        // Floyd's cycle detection algorithm ("tortoise and hare")
        boolean hasCycle() {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }

        void print() {
            Node current = head;
            StringBuilder sb = new StringBuilder();
            while (current != null) {
                sb.append(current.data).append(" -> ");
                current = current.next;
            }
            sb.append("null");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.print("Original: ");
        list.print();

        list.reverse();
        System.out.print("Reversed: ");
        list.print();

        System.out.println("Has cycle: " + list.hasCycle());

        // Manually creating a cycle to demonstrate detection
        list.head.next.next.next.next = list.head; // last node points back to head
        System.out.println("Has cycle after creating one: " + list.hasCycle());
    }
}

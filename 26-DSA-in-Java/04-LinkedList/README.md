# Linked List in DSA

## 📌 Topic
Linked List me data nodes me store hota hai aur har node agle node ko point karta hai. Yahan khud ki singly linked list banate hain.

## 🎯 What You Will Learn

- Node class
- Insert at head/tail
- Traverse aur delete
- Reverse linked list

## 💻 Code

```java
public class Linkedlist1 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node head;

    static void addLast(int data) {
        Node n = new Node(data);
        if (head == null) { head = n; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = n;
    }

    static void addFirst(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    static void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    static void reverse() {
        Node prev = null, cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    static void delete(int key) {
        if (head == null) return;
        if (head.data == key) { head = head.next; return; }
        Node cur = head;
        while (cur.next != null && cur.next.data != key) cur = cur.next;
        if (cur.next != null) cur.next = cur.next.next;
    }

    public static void main(String[] args) {
        addLast(10); addLast(20); addLast(30);
        addFirst(5);
        print();
        delete(20);
        print();
        reverse();
        print();
    }
}
```

## 🧠 Explanation

### `Node`
Har node me `data` aur agle node ka reference `next` hota hai. Aakhri node ka `next` `null` hota hai.

### `addFirst`
O(1): naya node head banta hai. addLast me traversal ki wajah se O(n).

### `reverse`
Teen pointers (`prev`, `cur`, `next`) se saare links ulte kar dete hain. O(n) time, O(1) space.

## ▶️ Output

```text
5 -> 10 -> 20 -> 30 -> null
5 -> 10 -> 30 -> null
30 -> 10 -> 5 -> null
```

## 🔑 Important Points

- Linked list me random access nahi hota, `get(i)` O(n) hai.
- Insert/delete (jab node mil jaye) O(1) hai, shifting nahi hoti.
- Interview classics: reverse, middle (slow/fast pointer), cycle detection, merge two sorted lists.

## 📝 Practice

1. Linked list ka middle element nikalo (slow/fast).
2. Cycle detect karo (Floyd).
3. Linked list ki length recursion se nikalo.
4. Do sorted linked lists merge karo.

## 🚀 Challenge

Linked list me se `n`-th node from end delete karo (ek hi pass me).

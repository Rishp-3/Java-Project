# Queue in Java

## 📌 Topic
`Queue` FIFO (First In First Out) principle par kaam karta hai. Jo element pehle aata hai wahi pehle nikalta hai, jaise line me khade log.

## 🎯 What You Will Learn

- Queue kya hai (FIFO)
- `offer()`, `poll()`, `peek()`
- `LinkedList` aur `PriorityQueue`
- Queue ke real-life examples

## 💻 Code

```java
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue1 {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.offer("A");
        q.offer("B");
        q.offer("C");

        System.out.println(q);
        System.out.println("Peek: " + q.peek());
        System.out.println("Poll: " + q.poll());
        System.out.println(q);
        System.out.println("Size: " + q.size());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        System.out.print("Priority order: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }
}
```

## 🧠 Explanation

### `offer()`
Queue ke end me element jodta hai.

### `poll()`
Aage ka element nikalta hai aur hata deta hai. Queue khali ho to `null`.

### `peek()`
Aage ka element sirf dekhta hai, hatata nahi.

### `PriorityQueue`
Elements priority se nikalte hain (default me sabse chhota number pehle), insertion order se nahi.

## ▶️ Output

```text
[A, B, C]
Peek: A
Poll: A
[B, C]
Size: 2
Priority order: 10 20 30 
```

## 🔑 Important Points

- `add/remove/element` exception dete hain, `offer/poll/peek` null return karte hain.
- `Queue` interface hai, object `LinkedList` ya `ArrayDeque` se banta hai.
- BFS, task scheduling aur printers me queue use hoti hai.

## 📝 Practice

1. Customers ki line (queue) simulate karo.
2. Queue ko reverse karo.
3. `PriorityQueue` me bade number pehle nikalo (`Collections.reverseOrder()`).
4. Stack ko do queues se banao.

## 🚀 Challenge

Queue me 1 se 5 daalo aur ek-ek karke nikalte hue print karo.

```text
1 2 3 4 5
```

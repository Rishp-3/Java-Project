# Queue in DSA

## 📌 Topic
Queue FIFO (First In First Out) data structure hai: jo pehle aaya wo pehle nikalta hai. Circular queue array ko dobara use karti hai.

## 🎯 What You Will Learn

- `enqueue`, `dequeue`, `front`
- Circular Queue ka implementation
- Queue ke use cases (BFS)
- Stack se Queue banana

## 💻 Code

```java
public class Queue1 {

    static class CircularQueue {
        private final int[] data;
        private int front = 0, size = 0;

        CircularQueue(int capacity) { data = new int[capacity]; }

        boolean enqueue(int x) {
            if (size == data.length) return false;
            data[(front + size) % data.length] = x;
            size++;
            return true;
        }

        int dequeue() {
            if (size == 0) throw new RuntimeException("Queue empty");
            int x = data[front];
            front = (front + 1) % data.length;
            size--;
            return x;
        }

        int front() { return data[front]; }
        boolean isEmpty() { return size == 0; }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);
        System.out.println(q.enqueue(1));
        System.out.println(q.enqueue(2));
        System.out.println(q.enqueue(3));
        System.out.println("Full? enqueue(4): " + q.enqueue(4));

        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Enqueue 4 after space: " + q.enqueue(4));
        System.out.println("Front: " + q.front());

        while (!q.isEmpty()) {
            System.out.print(q.dequeue() + " ");
        }
        System.out.println();
    }
}
```

## 🧠 Explanation

### `front aur size`
`front` pehle element ka index hai, `size` kitne elements hain.

### `% data.length`
Modulo se index end ke baad wapas 0 par aa jata hai, isliye queue circular banti hai aur jagah waste nahi hoti.

### `enqueue / dequeue`
Dono O(1) me.

## ▶️ Output

```text
true
true
true
Full? enqueue(4): false
Dequeue: 1
Enqueue 4 after space: true
Front: 2
2 3 4 
```

## 🔑 Important Points

- Simple array queue me dequeue ke baad aage ki jagah waste hoti hai, circular queue me nahi.
- Use cases: BFS, task scheduling, printer queue, buffering.
- Java me `Queue<Integer> q = new ArrayDeque<>();` use karo.
- Variants: Deque, Priority Queue.

## 📝 Practice

1. Queue ko reverse karo.
2. Do stacks se queue banao.
3. BFS ke liye queue use karo.
4. `PriorityQueue` se k-th largest element nikalo.

## 🚀 Challenge

Do queues se stack banao.

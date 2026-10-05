# Heap in DSA

## 📌 Topic
Heap ek complete binary tree hai jisme parent hamesha child se chhota (Min-Heap) ya bada (Max-Heap) hota hai. Priority Queue iske upar bani hai.

## 🎯 What You Will Learn

- Min-Heap aur Max-Heap
- Array me heap ka representation
- Insert (heapify up) aur extract (heapify down)
- Java ka `PriorityQueue`

## 💻 Code

```java
import java.util.*;

public class Heap {

    static class MinHeap {
        private final List<Integer> a = new ArrayList<>();

        void insert(int x) {
            a.add(x);
            int i = a.size() - 1;
            while (i > 0 && a.get((i - 1) / 2) > a.get(i)) {
                Collections.swap(a, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        int extractMin() {
            int min = a.get(0);
            int last = a.remove(a.size() - 1);
            if (!a.isEmpty()) {
                a.set(0, last);
                int i = 0;
                while (true) {
                    int l = 2 * i + 1, r = 2 * i + 2, small = i;
                    if (l < a.size() && a.get(l) < a.get(small)) small = l;
                    if (r < a.size() && a.get(r) < a.get(small)) small = r;
                    if (small == i) break;
                    Collections.swap(a, i, small);
                    i = small;
                }
            }
            return min;
        }

        boolean isEmpty() { return a.isEmpty(); }
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        for (int x : new int[]{40, 10, 30, 5, 20}) h.insert(x);

        System.out.print("Sorted via heap: ");
        while (!h.isEmpty()) System.out.print(h.extractMin() + " ");
        System.out.println();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Collections.addAll(maxHeap, 3, 9, 1, 7);
        System.out.println("Max: " + maxHeap.peek());

        int[] nums = {7, 2, 9, 4, 11, 5};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > 3) pq.poll();
        }
        System.out.println("3rd largest: " + pq.peek());
    }
}
```

## 🧠 Explanation

### `Array representation`
Node `i` ke children: `2i+1` (left), `2i+2` (right). Parent: `(i-1)/2`. Pointers ki zaroorat nahi.

### `insert`
End me daalo aur parent se chhota ho to upar swap karte jao. O(log n).

### `extractMin`
Root hatao, last element root par rakho aur niche swap karke thik karo. O(log n).

### `k-th largest`
Size `k` ka Min-Heap rakho. Heap ka top hi k-th largest hota hai.

## ▶️ Output

```text
Sorted via heap: 5 10 20 30 40 
Max: 9
3rd largest: 7
```

## 🔑 Important Points

- `peek()` O(1), `offer()`/`poll()` O(log n).
- Heap sort O(n log n) deta hai.
- Use cases: priority scheduling, Dijkstra, top-K problems, median of stream.
- Java `PriorityQueue` default Min-Heap hai.

## 📝 Practice

1. Max-Heap khud banao.
2. Array me k-th smallest element nikalo.
3. K sorted lists merge karo.
4. Stream ka median nikalo (do heaps).

## 🚀 Challenge

`PriorityQueue` se array ke top 3 sabse chhote elements nikalo.

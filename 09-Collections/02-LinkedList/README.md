# LinkedList in Java

## 📌 Topic
`LinkedList` elements ko nodes me store karta hai jahan har node apne agle (aur pichle) node ko point karta hai. Beech me insert/delete karna fast hota hai.

## 🎯 What You Will Learn

- LinkedList kya hai
- `addFirst()`, `addLast()`, `removeFirst()`, `removeLast()`
- ArrayList aur LinkedList me difference

## 💻 Code

```java
import java.util.LinkedList;

public class Linkedlist {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("B");
        list.add("C");
        list.addFirst("A");
        list.addLast("D");
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        list.add(1, "X");
        System.out.println(list);
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
    }
}
```

## 🧠 Explanation

### `addFirst / addLast`
Shuru ya end me element jodte hain. Dono O(1) hain.

### `removeFirst / removeLast`
Pehla ya aakhri element hata dete hain.

### `Doubly linked`
Java ka `LinkedList` doubly linked list hai, har node ke paas `prev` aur `next` dono hote hain.

## ▶️ Output

```text
[A, B, C, D]
[B, C]
[B, X, C]
First: B
Last: C
```

## 🔑 Important Points

- `LinkedList` List aur Deque dono interfaces implement karta hai.
- Random access (`get(i)`) slow hai: O(n).
- Baar-baar start/end me add-remove ho to `LinkedList` achha hai.
- Zyada tar cases me `ArrayList` hi behtar hota hai (memory aur cache ke kaaran).

## 📝 Practice

1. LinkedList me 5 elements daalo aur reverse print karo.
2. Middle element nikalo.
3. `LinkedList` ko stack ki tarah use karo (`push`, `pop`).
4. ArrayList aur LinkedList me 1 lakh insert ka time compare karo.

## 🚀 Challenge

LinkedList me numbers daalo aur sabhi duplicate numbers hata do.

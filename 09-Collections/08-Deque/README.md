# Deque in Java

## 📌 Topic
`Deque` (Double Ended Queue) me dono sirson (front aur rear) se element add aur remove ho sakte hain. Ise stack aur queue dono ki tarah use kar sakte hain.

## 🎯 What You Will Learn

- Deque kya hai
- `addFirst()`, `addLast()`, `pollFirst()`, `pollLast()`
- `ArrayDeque` ka use
- Deque ko stack ki tarah use karna

## 💻 Code

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Deque1 {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(10);
        dq.addLast(20);
        dq.addFirst(5);
        dq.addLast(30);
        System.out.println(dq);

        System.out.println("Removed first: " + dq.pollFirst());
        System.out.println("Removed last: " + dq.pollLast());
        System.out.println(dq);

        Deque<String> stack = new ArrayDeque<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
    }
}
```

## 🧠 Explanation

### `addFirst / addLast`
Dono sirson par element jodta hai.

### `pollFirst / pollLast`
Dono sirson se element nikalta hai.

### `push / pop`
`ArrayDeque` ko stack (LIFO) ki tarah use karne ke liye.

## ▶️ Output

```text
[5, 10, 20, 30]
Removed first: 5
Removed last: 30
[10, 20]
Pop: three
Peek: two
```

## 🔑 Important Points

- Stack ke liye purane `Stack` class ki jagah `ArrayDeque` use karo (fast hai).
- `ArrayDeque` me `null` allowed nahi hai.
- Sliding window problems me Deque bahut kaam aata hai.

## 📝 Practice

1. Deque se palindrome check karo.
2. Browser back/forward history simulate karo.
3. Deque se Stack banao aur balanced brackets check karo.
4. `peekFirst()` aur `peekLast()` try karo.

## 🚀 Challenge

Deque ka use karke check karo ki `racecar` palindrome hai ya nahi.

```text
racecar is palindrome
```

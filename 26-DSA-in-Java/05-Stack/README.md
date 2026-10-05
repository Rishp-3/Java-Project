# Stack in DSA

## 📌 Topic
Stack LIFO (Last In First Out) data structure hai: jo sabse baad me aaya, wo sabse pehle nikalta hai. Jaise plates ka dher.

## 🎯 What You Will Learn

- `push`, `pop`, `peek`, `isEmpty`
- Array se Stack banana
- Balanced brackets check karna
- `ArrayDeque` ko stack ki tarah use karna

## 💻 Code

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Stack1 {

    static class MyStack {
        private final int[] data = new int[10];
        private int top = -1;

        void push(int x) {
            if (top == data.length - 1) throw new RuntimeException("Stack overflow");
            data[++top] = x;
        }

        int pop() {
            if (top == -1) throw new RuntimeException("Stack underflow");
            return data[top--];
        }

        int peek() { return data[top]; }
        boolean isEmpty() { return top == -1; }
    }

    static boolean balanced(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char open = st.pop();
                if ((c == ')' && open != '(') || (c == '}' && open != '{') || (c == ']' && open != '[')) return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(10); s.push(20); s.push(30);
        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());
        System.out.println("Pop: " + s.pop());

        System.out.println(balanced("{[()]}"));
        System.out.println(balanced("{[(])}"));
        System.out.println(balanced("(("));
    }
}
```

## 🧠 Explanation

### `push / pop / peek`
Sab operations O(1) me hote hain. `top` pointer stack ka upar wala element dikhata hai.

### `Overflow / Underflow`
Full stack me push par overflow, khali stack se pop par underflow.

### `balanced()`
Opening bracket stack me daalo, closing bracket par top se match karo. End me stack khali ho to balanced.

## ▶️ Output

```text
Peek: 30
Pop: 30
Pop: 20
true
false
false
```

## 🔑 Important Points

- Java ka purana `Stack` class slow hai, `ArrayDeque` use karo.
- Use cases: undo/redo, function call stack, browser back, expression evaluation, DFS.
- Postfix expression evaluation aur next greater element classic stack problems hain.

## 📝 Practice

1. Stack se string reverse karo.
2. Postfix expression evaluate karo.
3. Next greater element nikalo.
4. Do stacks se queue banao.

## 🚀 Challenge

Min Stack banao jisme `getMin()` O(1) me ho.

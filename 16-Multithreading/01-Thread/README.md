# Thread in Java

## 📌 Topic
Thread program ke andar ek alag execution path hota hai. Multithreading me ek saath kai kaam (tasks) chal sakte hain.

## 🎯 What You Will Learn

- Thread kya hota hai aur multithreading kyu
- `Thread` class ko extend karke thread banana
- `start()` aur `run()` me difference
- `join()` se thread ka wait karna

## 💻 Code

```java
class MyThread extends Thread {
    private final String label;

    MyThread(String label) {
        this.label = label;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(label + " -> " + i);
        }
    }
}

public class Thread1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Thread-A");
        t1.start();
        t1.join();

        MyThread t2 = new MyThread("Thread-B");
        t2.start();
        t2.join();

        System.out.println("Main finished");
    }
}
```

## 🧠 Explanation

### `extends Thread`
`Thread` class ko extend karke `run()` override karte hain. `run()` me thread ka kaam likhte hain.

### `start()`
Naya thread banata hai aur `run()` ko us naye thread me chalata hai.

### `run()`
Seedha `run()` call karoge to naya thread nahi banega, wo normal method call hoga.

### `join()`
Calling thread tab tak ruka rehta hai jab tak ye thread khatam na ho jaye.

## ▶️ Output

```text
Thread-A -> 1
Thread-A -> 2
Thread-A -> 3
Thread-B -> 1
Thread-B -> 2
Thread-B -> 3
Main finished
```

## 🔑 Important Points

- Ek thread ko do baar `start()` nahi kar sakte (`IllegalThreadStateException`).
- Alag threads ka output order guarantee nahi hota; is example me `join()` se order fix kiya gaya hai.
- Java me class sirf ek class extend kar sakti hai, isliye `Runnable` zyada flexible hai.
- Main bhi ek thread hai (`main` thread).

## 📝 Practice

1. Do threads banao jo 1 se 5 tak print karein.
2. `Thread.currentThread().getName()` print karo.
3. Thread ko naam do (`new Thread(...).setName()`).
4. `start()` ki jagah `run()` call karke difference dekho.

## 🚀 Challenge

Teen threads banao jo apna naam 3-3 baar print karein. `join()` use karke main thread ko end me `All done` print karao.

# Thread Methods in Java

## 📌 Topic
Thread class ke important methods: `sleep()`, `join()`, `getName()`, `setPriority()`, `isAlive()`, `interrupt()` aur `setDaemon()`.

## 🎯 What You Will Learn

- `sleep()` aur `join()`
- Thread ka naam aur priority
- `isAlive()` aur thread states
- `interrupt()`

## 💻 Code

```java
public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("Working " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }, "MyWorker");

        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name: " + t.getName());
        System.out.println("Priority: " + t.getPriority());
        System.out.println("State before start: " + t.getState());

        t.start();
        System.out.println("Alive: " + t.isAlive());
        t.join();
        System.out.println("Alive after join: " + t.isAlive());
        System.out.println("State at end: " + t.getState());

        Thread sleeper = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Sleeper was interrupted");
            }
        });
        sleeper.start();
        sleeper.interrupt();
        sleeper.join();
    }
}
```

## 🧠 Explanation

### `Thread.sleep(ms)`
Current thread ko kuch milliseconds ke liye rok deta hai. `InterruptedException` handle karni padti hai.

### `setPriority / getPriority`
Priority 1 se 10 tak hoti hai. Ye sirf hint hai, order guarantee nahi.

### `getState()`
Thread states: `NEW`, `RUNNABLE`, `BLOCKED`, `WAITING`, `TIMED_WAITING`, `TERMINATED`.

### `interrupt()`
Sleeping/waiting thread ko jagata hai aur `InterruptedException` throw karwata hai.

## ▶️ Output

```text
Name: MyWorker
Priority: 10
State before start: NEW
Working 1
Alive: true
Working 2
Working 3
Alive after join: false
State at end: TERMINATED
Sleeper was interrupted
```

## 🔑 Important Points

- `setDaemon(true)` background thread banata hai, jo tab band ho jata hai jab saare normal threads khatam ho jayein.
- `sleep()` lock release nahi karta, `wait()` karta hai.
- Thread ko dobara start nahi kar sakte.

## 📝 Practice

1. Thread me countdown 5 se 1 tak 1 second ke gap se chalao.
2. Thread ka state alag-alag jagah print karo.
3. Daemon thread banao aur behaviour dekho.
4. Ek thread ko `interrupt` karo.

## 🚀 Challenge

Ek digital clock banao jo har second time print kare (5 baar) `Thread.sleep(1000)` se.

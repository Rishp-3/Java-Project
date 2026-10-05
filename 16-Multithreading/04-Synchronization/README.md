# Synchronization in Java

## 📌 Topic
Jab kai threads ek hi shared data ko ek saath badalte hain to galat result (race condition) aa sakta hai. `synchronized` keyword se ek time par sirf ek thread us code ko chala sakta hai.

## 🎯 What You Will Learn

- Race condition kya hai
- `synchronized` method aur block
- Lock ka concept
- `AtomicInteger`

## 💻 Code

```java
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        AtomicInteger atomic = new AtomicInteger();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
                atomic.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Synchronized count: " + counter.getCount());
        System.out.println("Atomic count: " + atomic.get());
    }
}
```

## 🧠 Explanation

### `count++`
Ye ek step nahi hai: padhna, badhana, likhna (3 steps). Do threads beech me aa jayein to updates kho jate hain (race condition).

### `synchronized`
Method par lagane se object ka lock lagta hai, ek time par sirf ek thread andar ja sakta hai.

### `AtomicInteger`
Lock ke bina thread-safe counter deta hai (hardware level atomic operations).

## ▶️ Output

```text
Synchronized count: 20000
Atomic count: 20000
```

## 🔑 Important Points

- `synchronized` hataoge to count aksar 20000 se kam aayega.
- Zaroorat se bada synchronized block performance kam karta hai, chhota rakho.
- Static method par `synchronized` class-level lock lagata hai.
- Deadlock tab hota hai jab do threads ek-doosre ka lock wait karte hain.

## 📝 Practice

1. `synchronized` hata ke race condition dekho.
2. `synchronized` block (`synchronized(this) {}`) use karo.
3. Do threads se bank account me deposit/withdraw safe banao.
4. Deadlock ka simple example banao.

## 🚀 Challenge

Ticket booking class banao jisme 5 seats hon aur 10 threads book karne ki koshish karein. Overbooking na ho.

# Runnable Interface in Java

## 📌 Topic
`Runnable` interface se thread ka kaam alag define kiya ja sakta hai. Ye `Thread` extend karne se behtar tarika hai kyunki class kisi aur class ko bhi extend kar sakti hai.

## 🎯 What You Will Learn

- `Runnable` interface implement karna
- `Thread` ko `Runnable` dena
- Lambda se `Runnable` banana
- `Thread` vs `Runnable`

## 💻 Code

```java
class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Task running in: " + Thread.currentThread().getName());
    }
}

public class Runnable1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task(), "Worker-1");
        t1.start();
        t1.join();

        Thread t2 = new Thread(() -> {
            System.out.println("Lambda running in: " + Thread.currentThread().getName());
        }, "Worker-2");
        t2.start();
        t2.join();

        System.out.println("Done");
    }
}
```

## 🧠 Explanation

### `implements Runnable`
Sirf kaam (`run()`) define karta hai, thread nahi banata.

### `new Thread(task, name)`
Thread object `Runnable` leke banta hai. `start()` karne par `run()` chalta hai.

### `Lambda`
`Runnable` me ek hi method hai, isliye lambda `() -> { ... }` likh sakte ho.

## ▶️ Output

```text
Task running in: Worker-1
Lambda running in: Worker-2
Done
```

## 🔑 Important Points

- Ek hi `Runnable` object ko kai threads me share kar sakte ho.
- `Runnable` kuch return nahi karta; return value chahiye to `Callable` use karo.
- Practical code me `Runnable` ya `ExecutorService` prefer hota hai.

## 📝 Practice

1. `Runnable` se 1 se 5 print karne wala thread banao.
2. Do threads ek hi `Runnable` object share karke chalao.
3. Lambda se thread banao.
4. `Callable` aur `Future` ke baare me padho.

## 🚀 Challenge

`Runnable` se ek thread banao jo 1 se 10 tak numbers ka sum print kare.

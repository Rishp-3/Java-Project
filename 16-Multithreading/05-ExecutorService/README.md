# ExecutorService in Java

## 📌 Topic
`ExecutorService` threads ka pool manage karta hai. Har task ke liye naya thread banane ke bajaye pehle se bane threads reuse hote hain.

## 🎯 What You Will Learn

- Thread pool ka concept
- `Executors.newFixedThreadPool()`
- `submit()`, `Callable` aur `Future`
- `shutdown()` aur `awaitTermination()`

## 💻 Code

```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Executorservice {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        List<Future<Integer>> results = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int n = i;
            Callable<Integer> task = () -> n * n;
            results.add(pool.submit(task));
        }

        for (Future<Integer> f : results) {
            System.out.println("Result: " + f.get());
        }

        Future<?> done = pool.submit(() -> System.out.println("Runnable task ran"));
        done.get();

        pool.shutdown();
        System.out.println("Terminated: " + pool.awaitTermination(2, TimeUnit.SECONDS));
    }
}
```

## 🧠 Explanation

### `newFixedThreadPool(3)`
Sirf 3 threads ka pool. 5 tasks hon to baaki queue me wait karte hain.

### `Callable<Integer>`
`Runnable` jaisa hi, par value return kar sakta hai aur exception throw kar sakta hai.

### `Future.get()`
Task ka result deta hai. Result ready na ho to wait karta hai.

### `shutdown()`
Naye tasks lena band karta hai, purane khatam hone deta hai. Isko call na karo to program band nahi hota.

## ▶️ Output

```text
Result: 1
Result: 4
Result: 9
Result: 16
Result: 25
Runnable task ran
Terminated: true
```

## 🔑 Important Points

- Pool ka size CPU cores aur task type (CPU/IO) ke hisab se rakho.
- Hamesha `shutdown()` call karo.
- Other pools: `newCachedThreadPool()`, `newSingleThreadExecutor()`, `newScheduledThreadPool()`.
- Naye code me `CompletableFuture` bhi bahut use hota hai.

## 📝 Practice

1. 10 tasks ko 3 threads ke pool me chalao.
2. `Callable` se factorial return karwao.
3. `invokeAll()` try karo.
4. `ScheduledExecutorService` se task delay se chalao.

## 🚀 Challenge

`ExecutorService` se 5 numbers ke squares parallel nikalo aur unka total print karo.

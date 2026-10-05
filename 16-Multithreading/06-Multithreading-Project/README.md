# Multithreading Mini Project

## 📌 Topic
Is project me ek Download Manager simulate kiya gaya hai jisme kai files parallel me `ExecutorService` se download hoti hain aur total progress safe tarike se count hota hai.

## 🎯 What You Will Learn

- Thread pool ka practical use
- Shared counter ko thread-safe rakhna
- `CountDownLatch` se saare tasks ka wait
- Parallel tasks ka result jama karna

## 💻 Code

```java
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadingProject {

    public static void main(String[] args) throws InterruptedException {
        String[] files = {"video.mp4", "song.mp3", "report.pdf", "photo.png"};
        int[] sizes = {400, 120, 80, 60};

        ExecutorService pool = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(files.length);
        AtomicInteger totalMb = new AtomicInteger();
        ConcurrentHashMap<String, String> status = new ConcurrentHashMap<>();

        for (int i = 0; i < files.length; i++) {
            final String name = files[i];
            final int size = sizes[i];
            pool.submit(() -> {
                try {
                    Thread.sleep(size);
                    totalMb.addAndGet(size);
                    status.put(name, "done");
                } catch (InterruptedException e) {
                    status.put(name, "failed");
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        pool.shutdown();

        for (String f : files) {
            System.out.println(f + " -> " + status.get(f));
        }
        System.out.println("Total downloaded: " + totalMb.get() + " MB");
    }
}
```

## 🧠 Explanation

### `CountDownLatch`
Counter jo har task ke khatam hone par ghatta hai. `await()` tab tak rukta hai jab tak ye 0 na ho jaye.

### `AtomicInteger`
Kai threads ek saath total add kar rahe hain, isliye thread-safe counter zaroori hai.

### `ConcurrentHashMap`
Thread-safe map, jisme har task apna status daalta hai.

## ▶️ Output

```text
video.mp4 -> done
song.mp3 -> done
report.pdf -> done
photo.png -> done
Total downloaded: 660 MB
```

## 🔑 Important Points

- `finally` me `countDown()` rakho taaki task fail hone par bhi program latka na rahe.
- Real download me `Thread.sleep()` ki jagah network I/O hota hai.
- Zyada threads hamesha tez nahi hote, pool size sochke rakho.

## 📝 Practice

1. Progress percentage print karo.
2. Fail hone wali file ke liye retry logic jodo.
3. `CompletableFuture` se same project banao.
4. Pool size 1, 2, 4 karke total time naapo.

## 🚀 Challenge

Project me ek `Scheduler` jodo jo har 1 second me progress print kare (`ScheduledExecutorService`).

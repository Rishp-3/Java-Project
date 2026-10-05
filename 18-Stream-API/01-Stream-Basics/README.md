# Stream API Basics in Java

## 📌 Topic
Stream (Java 8+) collection ke data ko functional style me process karne ka tarika hai: source se data lo, operations lagao, result nikalo.

## 🎯 What You Will Learn

- Stream kya hai
- Stream banana (`stream()`, `Stream.of()`, `IntStream.range()`)
- Intermediate aur Terminal operations
- Stream ek baar hi use ho sakta hai

## 💻 Code

```java
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBasics {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 2, 8, 1, 9, 3);

        System.out.println("Count: " + nums.stream().count());
        System.out.println("Max: " + nums.stream().max(Integer::compare).get());

        nums.stream()
            .filter(n -> n > 3)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        Stream.of("a", "b", "c").forEach(System.out::print);
        System.out.println();

        System.out.println("Sum 1..5 = " + IntStream.rangeClosed(1, 5).sum());

        Stream<Integer> s = nums.stream();
        s.count();
        try {
            s.count();
        } catch (IllegalStateException e) {
            System.out.println("Stream already used");
        }
    }
}
```

## 🧠 Explanation

### `nums.stream()`
List se stream banata hai. Original list nahi badalti.

### `Intermediate operation`
`filter`, `map`, `sorted` jaise operations naya stream return karte hain aur lazy hote hain (tab tak nahi chalte jab tak terminal operation na aaye).

### `Terminal operation`
`count`, `forEach`, `collect`, `sum` jaise operations result deke stream khatam kar dete hain.

### `IntStream.rangeClosed(1, 5)`
1 se 5 tak ke numbers ka primitive stream.

## ▶️ Output

```text
Count: 6
Max: 9
5 8 9 
abc
Sum 1..5 = 15
Stream already used
```

## 🔑 Important Points

- Stream data store nahi karta, sirf process karta hai.
- Ek stream ek hi baar use ho sakta hai.
- Terminal operation ke bina kuch nahi chalta.
- Bade data par `parallelStream()` bhi hota hai (dhyan se use karo).

## 📝 Practice

1. List ke saare numbers ka sum stream se nikalo.
2. List me even numbers count karo.
3. Strings ki list ko uppercase me print karo.
4. `IntStream.range(0, 5)` print karo.

## 🚀 Challenge

1 se 100 tak ke numbers me se sirf 7 ke multiples stream se print karo.

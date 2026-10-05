# Stream API Mini Project

## 📌 Topic
Is mini project me ek Order Analysis system banaya hai jisme Stream API se filter, map, group, sort aur reduce sab ek saath use hote hain.

## 🎯 What You Will Learn

- Stream operations ko chain karna
- Business questions ka jawab Stream se nikalna
- `groupingBy`, `sorted`, `limit`, `mapToDouble`

## 💻 Code

```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamProject {

    record Order(int id, String customer, String category, double amount) {}

    public static void main(String[] args) {
        List<Order> orders = List.of(
            new Order(1, "Rishabh", "Electronics", 25000),
            new Order(2, "Amit", "Books", 800),
            new Order(3, "Neha", "Electronics", 15000),
            new Order(4, "Rishabh", "Books", 1200),
            new Order(5, "Rahul", "Clothes", 3000),
            new Order(6, "Neha", "Clothes", 4500)
        );

        double total = orders.stream().mapToDouble(Order::amount).sum();
        System.out.println("Total revenue: " + total);

        System.out.println("Average order: " + orders.stream().mapToDouble(Order::amount).average().orElse(0));

        Map<String, Double> byCategory = orders.stream()
                .collect(Collectors.groupingBy(Order::category, TreeMap::new, Collectors.summingDouble(Order::amount)));
        System.out.println("By category: " + byCategory);

        System.out.println("Top 2 orders:");
        orders.stream()
              .sorted(Comparator.comparingDouble(Order::amount).reversed())
              .limit(2)
              .forEach(o -> System.out.println("  " + o.customer() + " - " + o.amount()));

        System.out.println("Customers (unique, sorted): " +
            orders.stream().map(Order::customer).distinct().sorted().collect(Collectors.toList()));

        Optional<Map.Entry<String, Double>> best = orders.stream()
                .collect(Collectors.groupingBy(Order::customer, Collectors.summingDouble(Order::amount)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
        System.out.println("Best customer: " + best.get().getKey());
    }
}
```

## 🧠 Explanation

### `mapToDouble(...).sum()`
Sab orders ka total ek line me.

### `groupingBy(..., TreeMap::new, ...)`
Category ke hisab se group, aur result sorted map me.

### `sorted + limit`
Top-N queries ka standard tarika.

### `max(Map.Entry.comparingByValue())`
Map me sabse badi value wali entry dhoondhta hai.

## ▶️ Output

```text
Total revenue: 49500.0
Average order: 8250.0
By category: {Books=2000.0, Clothes=7500.0, Electronics=40000.0}
Top 2 orders:
  Rishabh - 25000.0
  Neha - 15000.0
Customers (unique, sorted): [Amit, Neha, Rahul, Rishabh]
Best customer: Rishabh
```

## 🔑 Important Points

- Stream chain ko sawaal ki tarah padho: filter, group, sort, limit.
- Bahut lambi chain ho to beech me variables ya methods banao.
- Same kaam loops se bhi ho sakta hai, par Stream zyada declarative aur short hai.

## 📝 Practice

1. Sabse zyada orders dene wale customer ka naam nikalo.
2. Har category ka highest order nikalo.
3. 10,000 se upar ke orders ka count nikalo.
4. Orders ko customer ke hisab se group karke unka count print karo.

## 🚀 Challenge

Project me `Scanner` se naya order add karne ka option jodo aur report dobara print karo.

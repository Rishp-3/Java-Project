# Wildcards in Java Generics

## 📌 Topic
Wildcard `?` ka matlab hai 'koi bhi unknown type'. Jab method alag-alag generic types ki list ek saath leni ho tab ye kaam aata hai.

## 🎯 What You Will Learn

- Unbounded wildcard `<?>`
- Upper bounded `<? extends T>`
- Lower bounded `<? super T>`
- PECS rule

## 💻 Code

```java
import java.util.ArrayList;
import java.util.List;

public class Wildcards {

    static void printAll(List<?> list) {
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    static double sum(List<? extends Number> list) {
        double total = 0;
        for (Number n : list) {
            total += n.doubleValue();
        }
        return total;
    }

    static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(10, 20, 30));
        List<Double> doubles = new ArrayList<>(List.of(1.5, 2.5));
        List<String> strs = new ArrayList<>(List.of("a", "b"));

        printAll(ints);
        printAll(strs);
        System.out.println(sum(ints));
        System.out.println(sum(doubles));

        List<Number> numbers = new ArrayList<>();
        addNumbers(numbers);
        System.out.println(numbers);
    }
}
```

## 🧠 Explanation

### `List<?>`
Kisi bhi type ki list le sakta hai, par usme naya element add nahi kar sakte (sirf read).

### `List<? extends Number>`
Upper bound: `Number` ya uski child types ki list. Padh sakte ho, likh nahi sakte.

### `List<? super Integer>`
Lower bound: `Integer` ya uske parent types ki list. Isme `Integer` add kar sakte ho.

## ▶️ Output

```text
10 20 30 
a b 
60.0
4.0
[1, 2]
```

## 🔑 Important Points

- PECS: Producer Extends, Consumer Super.
- `List<Integer>` ko `List<Number>` me assign nahi kar sakte, par `List<? extends Number>` me kar sakte ho.
- Wildcard variable ya method parameter me use hota hai, class declare karte waqt nahi.

## 📝 Practice

1. `List<?>` wale method me `add()` karke error dekho.
2. `List<? extends Number>` se max nikalo.
3. `List<? super Integer>` me elements add karo.
4. `copy(List<? super T> dest, List<? extends T> src)` banao.

## 🚀 Challenge

`printList(List<?> list)` method banao aur use `List<Integer>`, `List<String>` dono ke saath chalao.

# Generic Method in Java

## 📌 Topic
Generic method ka apna type parameter hota hai, aur wo class generic na hone par bhi kisi bhi type ke saath kaam kar sakta hai.

## 🎯 What You Will Learn

- Generic method ka syntax
- Array print karne wala generic method
- Bounded type (`T extends Number`)

## 💻 Code

```java
public class GenericMethod {

    static <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    static <T> T firstElement(T[] arr) {
        return arr[0];
    }

    static <T extends Number> double sum(T[] arr) {
        double total = 0;
        for (T n : arr) {
            total += n.doubleValue();
        }
        return total;
    }

    static <T extends Comparable<T>> T maxOf(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3};
        String[] names = {"Rishabh", "Amit"};

        printArray(nums);
        printArray(names);
        System.out.println(firstElement(names));
        System.out.println(sum(nums));
        System.out.println(maxOf(10, 20));
        System.out.println(maxOf("apple", "banana"));
    }
}
```

## 🧠 Explanation

### `<T> void printArray(T[] arr)`
`<T>` return type se pehle likhte hain. Ab ye method kisi bhi type ke array par chalega.

### `<T extends Number>`
Bounded type: `T` sirf `Number` ya uski child classes (`Integer`, `Double`) ho sakta hai.

### `T extends Comparable<T>`
Aisi type jo compare ho sake, taaki `compareTo()` use kar sakein.

## ▶️ Output

```text
1 2 3 
Rishabh Amit 
Rishabh
6.0
20
banana
```

## 🔑 Important Points

- Compiler type khud infer kar leta hai, `<Integer>printArray(nums)` likhna zaroori nahi.
- Generic methods static bhi ho sakte hain.
- Primitive arrays (`int[]`) generic method me `T[]` ke roop me nahi aate, `Integer[]` use karo.

## 📝 Practice

1. `swap(T[] arr, int i, int j)` generic method banao.
2. `count(T[] arr, T key)` banao.
3. `T extends Number` se average nikalo.
4. `isEqual(T a, T b)` banao.

## 🚀 Challenge

Generic method `reverse(T[] arr)` banao jo kisi bhi array ko reverse kar de.

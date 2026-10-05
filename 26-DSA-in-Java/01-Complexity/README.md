# Time and Space Complexity in Java

## 📌 Topic
Complexity batati hai ki input bada hone par algorithm kitna time (aur memory) lega. Isse hum algorithms ki tulna karte hain. Notation: Big-O.

## 🎯 What You Will Learn

- Big-O notation: O(1), O(log n), O(n), O(n log n), O(n^2)
- Time aur Space complexity me difference
- Code dekh kar complexity nikalna
- Operations count karke samajhna

## 💻 Code

```java
public class Complexity {

    static int first(int[] a) {                 // O(1)
        return a[0];
    }

    static int sum(int[] a) {                   // O(n)
        int s = 0;
        for (int x : a) s += x;
        return s;
    }

    static int pairs(int[] a) {                 // O(n^2)
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                count++;
        return count;
    }

    static int halvingSteps(int n) {            // O(log n)
        int steps = 0;
        while (n > 1) {
            n /= 2;
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] a = new int[1000];
        System.out.println("O(1): " + first(a));
        System.out.println("O(n) sum of 1000 items: " + sum(a));
        System.out.println("O(n^2) operations for n=1000: " + pairs(a));
        System.out.println("O(log n) steps for n=1000: " + halvingSteps(1000));
    }
}
```

## 🧠 Explanation

### `O(1)`
Constant time: input kitna bhi bada ho, kaam same.

### `O(n)`
Linear: input double hone par kaam double.

### `O(n^2)`
Quadratic: nested loops. n = 1000 par 10 lakh operations.

### `O(log n)`
Har step me input aadha hota hai. 1000 ke liye sirf ~10 steps.

## ▶️ Output

```text
O(1): 0
O(n) sum of 1000 items: 0
O(n^2) operations for n=1000: 1000000
O(log n) steps for n=1000: 9
```

## 🔑 Important Points

- Order (best to worst): O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(2^n).
- Constants aur chhote terms ignore hote hain: `3n + 5` = O(n).
- Nested loops aksar multiply hote hain, sequential loops add.
- Space complexity me extra memory gini jati hai (input chhodke).

## 📝 Practice

1. Teen alag loops ki complexity likho.
2. Binary search ki complexity batao aur kyu.
3. `for(i) for(j=i; ...)` ki complexity nikalo.
4. Recursive Fibonacci ki complexity sochho.

## 🚀 Challenge

Linear search aur Binary search ke liye 1 million elements par worst case kitne steps lagenge, calculate karo.

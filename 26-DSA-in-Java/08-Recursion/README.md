# Recursion in DSA

## 📌 Topic
Recursion me problem ko chhoti same type ki problems me todte hain. DSA me ye trees, divide & conquer aur backtracking ki neev hai.

## 🎯 What You Will Learn

- Base case aur recursive case sochna
- Power function (fast exponentiation)
- Tower of Hanoi
- Recursion tree se complexity samajhna

## 💻 Code

```java
public class Recursion1 {

    static long power(long base, int exp) {
        if (exp == 0) return 1;
        long half = power(base, exp / 2);
        if (exp % 2 == 0) return half * half;
        return half * half * base;
    }

    static int moves = 0;

    static void hanoi(int n, char from, char to, char via) {
        if (n == 0) return;
        hanoi(n - 1, from, via, to);
        moves++;
        if (n == 3 || moves <= 3) System.out.println("Move disk " + n + " " + from + " -> " + to);
        hanoi(n - 1, via, to, from);
    }

    static int sumDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigits(n / 10);
    }

    static boolean isPalindrome(String s, int i, int j) {
        if (i >= j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return isPalindrome(s, i + 1, j - 1);
    }

    public static void main(String[] args) {
        System.out.println("2^10 = " + power(2, 10));
        System.out.println("Sum of digits of 4321 = " + sumDigits(4321));
        System.out.println(isPalindrome("level", 0, 4));
        hanoi(3, 'A', 'C', 'B');
        System.out.println("Total moves: " + moves);
    }
}
```

## 🧠 Explanation

### `power()`
Exponent ko aadha karke solve karta hai, isliye O(log n). Seedha loop O(n) hota.

### `hanoi()`
`n` disks ko hilane ke liye: `n-1` via ko, ek bada disk `to` ko, phir `n-1` wapas upar. Total moves = `2^n - 1`.

### `Base case`
Har function me pehle base case likho, tabhi recursion rukega.

## ▶️ Output

```text
2^10 = 1024
Sum of digits of 4321 = 10
true
Move disk 1 A -> C
Move disk 2 A -> B
Move disk 1 C -> B
Move disk 3 A -> C
Total moves: 7
```

## 🔑 Important Points

- Har recursion call stack memory leta hai: space O(depth).
- Overlapping subproblems ho (Fibonacci) to memoization/DP use karo.
- Tail recursion ko Java optimize nahi karta, bahut deep recursion me loop behtar hai.

## 📝 Practice

1. Array ka sum recursion se nikalo.
2. Binary search recursion se likho.
3. Subsets generate karo.
4. Merge sort recursion se likho.

## 🚀 Challenge

Recursion se Pascal's triangle ki n-th row print karo.

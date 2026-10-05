# Greedy Algorithms in DSA

## 📌 Topic
Greedy approach me har step par wahi choice li jati hai jo us waqt sabse achhi lage, is umeed me ki isse final answer bhi best milega.

## 🎯 What You Will Learn

- Greedy ka idea
- Activity Selection
- Coin Change (greedy kab chalta hai)
- Fractional Knapsack

## 💻 Code

```java
import java.util.*;

public class Greedy {

    static int maxActivities(int[][] acts) {
        Arrays.sort(acts, (a, b) -> a[1] - b[1]);
        int count = 1, lastEnd = acts[0][1];
        for (int i = 1; i < acts.length; i++) {
            if (acts[i][0] >= lastEnd) {
                count++;
                lastEnd = acts[i][1];
            }
        }
        return count;
    }

    static int minCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        return count;
    }

    static double fractionalKnapsack(int[] w, int[] v, int cap) {
        Integer[] idx = new Integer[w.length];
        for (int i = 0; i < idx.length; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Double.compare((double) v[b] / w[b], (double) v[a] / w[a]));
        double total = 0;
        for (int i : idx) {
            if (cap >= w[i]) {
                cap -= w[i];
                total += v[i];
            } else {
                total += v[i] * ((double) cap / w[i]);
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] acts = {{1, 3}, {2, 5}, {4, 6}, {6, 8}, {5, 9}, {8, 10}};
        System.out.println("Max activities: " + maxActivities(acts));
        System.out.println("Min coins for 93: " + minCoins(new int[]{1, 2, 5, 10, 20, 50, 100}, 93));
        System.out.println("Knapsack value: " + fractionalKnapsack(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50));
    }
}
```

## 🧠 Explanation

### `Activity Selection`
End time ke hisab se sort karo aur jo pehle khatam hota hai wo lo. Isse baaki activities ke liye sabse zyada jagah bachti hai.

### `Coin Change`
Sabse bada coin pehle lo. Ye India/US jaise standard coin systems me sahi hai, par har coin set ke liye nahi (jaise `{1, 3, 4}` aur amount 6).

### `Fractional Knapsack`
Value/weight ratio ke hisab se sort karke bhar do, aakhri item ka fraction le sakte hain.

## ▶️ Output

```text
Max activities: 4
Min coins for 93: 5
Knapsack value: 240.0
```

## 🔑 Important Points

- Greedy hamesha optimal nahi hota. Sahi hone ka proof zaroori hai.
- Agar greedy fail ho to Dynamic Programming sochho.
- Zyada tar greedy problems me pehle sorting hoti hai.
- Famous: Huffman coding, Dijkstra, Prim, Kruskal.

## 📝 Practice

1. Meeting rooms problem solve karo.
2. Jump Game solve karo.
3. Gas Station problem solve karo.
4. `{1, 3, 4}` aur amount 6 par greedy coin change fail karke dekho.

## 🚀 Challenge

Minimum number of platforms (train station) greedy se nikalo.

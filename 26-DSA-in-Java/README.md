# 26 - DSA in Java

Interview preparation ke liye Data Structures & Algorithms. Is module me do cheezein hain:

1. **Topic folders (`01-` se `16-`)** - har topic ka ek chhota runnable demo (`javac` + `java` se chalao).
2. **Tested problems** - `src/main/java/practice/dsa/` me classic interview problems, har ek ka JUnit test `src/test/java/practice/dsa/` me.

```bash
mvn test -Dtest='DsaProblemsTest,DsaClassicsTest'
```

---

## 📊 Big-O Cheat Sheet

### Data structures (average case)

| Structure | Access | Search | Insert | Delete | Note |
|-----------|--------|--------|--------|--------|------|
| Array | O(1) | O(n) | O(n) | O(n) | Random access fast, beech me insert/delete slow |
| ArrayList | O(1) | O(n) | O(1)* | O(n) | *amortized, end me add karne par |
| LinkedList | O(n) | O(n) | O(1)** | O(1)** | **node mil jaye to |
| Stack / Queue / Deque | - | O(n) | O(1) | O(1) | `ArrayDeque` use karo |
| HashMap / HashSet | - | O(1) | O(1) | O(1) | Worst case O(n) (bahut collisions) |
| TreeMap / TreeSet | - | O(log n) | O(log n) | O(log n) | Sorted order milta hai |
| PriorityQueue (heap) | peek O(1) | O(n) | O(log n) | O(log n) | min-heap by default |
| BST (balanced) | - | O(log n) | O(log n) | O(log n) | Unbalanced ho to O(n) |

### Algorithms

| Algorithm | Time | Space | Note |
|-----------|------|-------|------|
| Binary search | O(log n) | O(1) | Sorted data chahiye |
| Bubble / Insertion sort | O(n^2) | O(1) | Chhote input ke liye |
| Merge sort | O(n log n) | O(n) | Stable, hamesha O(n log n) |
| Quick sort | O(n log n) avg, O(n^2) worst | O(log n) | In-place, fast in practice |
| Heap sort | O(n log n) | O(1) | Stable nahi hai |
| BFS / DFS | O(V + E) | O(V) | Graph traversal |
| Dijkstra (heap) | O((V + E) log V) | O(V) | Non-negative weights |

### Quick rule: input size se complexity guess karo

| n (approx) | Chalne wali complexity |
|-----------|------------------------|
| up to 10-12 | O(n!) - permutations / backtracking |
| up to 20-25 | O(2^n) - subsets |
| up to 500 | O(n^3) |
| up to 5,000 | O(n^2) |
| up to 10^6 | O(n log n) |
| 10^7 ya zyada | O(n) ya O(log n) |

---

## 🧩 Problem Index (pattern ke hisaab se)

Har method ke Javadoc me **idea** aur **time/space complexity** likhi hai.

### `DsaProblems` (basics)

| Problem | Pattern | Time |
|---------|---------|------|
| Maximum subarray (Kadane) | Dynamic programming | O(n) |
| Reverse linked list | Pointer manipulation | O(n) |
| Cycle detection | Fast & slow pointers | O(n) |
| Level-order traversal | BFS | O(n) |
| Validate BST | DFS with bounds | O(n) |
| Shortest path (unweighted) | BFS | O(V + E) |
| Coin change | DP | O(amount x coins) |
| Longest increasing subsequence | DP | O(n^2) |
| Permutations | Backtracking | O(n x n!) |
| Merge sort | Divide & conquer | O(n log n) |

### `DsaClassics` (LeetCode-style)

| Problem | Pattern | Time | Space |
|---------|---------|------|-------|
| Two Sum | Hashing | O(n) | O(n) |
| Contains Duplicate | Hashing | O(n) | O(n) |
| Product of Array Except Self | Prefix / suffix | O(n) | O(1) extra |
| Best Time to Buy & Sell Stock | Running minimum | O(n) | O(1) |
| Top K Frequent Elements | Heap | O(n log k) | O(n) |
| Merge Intervals | Sorting | O(n log n) | O(n) |
| Valid Parentheses | Stack | O(n) | O(n) |
| Longest Substring Without Repeating | Sliding window | O(n) | O(charset) |
| Merge Two Sorted Lists | Two pointers | O(n + m) | O(1) |
| Lowest Common Ancestor (BST) | BST property | O(h) | O(1) |
| Number of Islands | Grid DFS | O(R x C) | O(R x C) |
| Climbing Stairs | DP (Fibonacci) | O(n) | O(1) |
| Edit Distance | 2D DP | O(n x m) | O(n x m) |

---

## 🚀 Challenges (khud try karo)

Pehle brute force likho, phir complexity improve karo. Apna solution `src/main/java/practice/dsa/` me daalo aur test likho.

1. **3Sum** - sab unique triplets jinka sum 0 ho (sort + two pointers, O(n^2)).
2. **Valid Anagram / Group Anagrams** - hashing ya sorted key.
3. **Kth Largest Element** - min-heap of size k.
4. **Binary Tree Maximum Depth / Diameter** - DFS.
5. **Course Schedule** - graph me cycle detection (topological sort).
6. **Word Search** - grid backtracking.
7. **House Robber** - 1D DP.
8. **Longest Common Subsequence** - 2D DP.
9. **Subsets** - backtracking.
10. **Trapping Rain Water** - two pointers.

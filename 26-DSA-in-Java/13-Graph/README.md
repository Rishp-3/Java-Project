# Graph in DSA

## 📌 Topic
Graph me nodes (vertices) aur unko jodne wale edges hote hain. Social network, maps aur internet graphs ke examples hain.

## 🎯 What You Will Learn

- Adjacency List representation
- BFS (Breadth First Search)
- DFS (Depth First Search)
- Cycle aur connected components ka idea

## 💻 Code

```java
import java.util.*;

public class Graph {

    static class G {
        private final Map<Integer, List<Integer>> adj = new TreeMap<>();

        void addEdge(int u, int v) {
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        void bfs(int start) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited.add(start);
            while (!q.isEmpty()) {
                int u = q.poll();
                System.out.print(u + " ");
                for (int v : adj.get(u)) {
                    if (visited.add(v)) q.add(v);
                }
            }
            System.out.println();
        }

        void dfs(int u, Set<Integer> visited) {
            visited.add(u);
            System.out.print(u + " ");
            for (int v : adj.get(u)) {
                if (!visited.contains(v)) dfs(v, visited);
            }
        }

        boolean hasPath(int src, int dst, Set<Integer> visited) {
            if (src == dst) return true;
            visited.add(src);
            for (int v : adj.get(src)) {
                if (!visited.contains(v) && hasPath(v, dst, visited)) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        G g = new G();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.print("BFS from 1: ");
        g.bfs(1);

        System.out.print("DFS from 1: ");
        g.dfs(1, new HashSet<>());
        System.out.println();

        System.out.println("Path 1 -> 5: " + g.hasPath(1, 5, new HashSet<>()));
    }
}
```

## 🧠 Explanation

### `Adjacency List`
Har node ke saath uske padosiyon ki list. Memory O(V + E), sparse graphs ke liye best.

### `BFS`
Queue use karta hai, nazdeeki nodes pehle visit hote hain. Unweighted graph me shortest path deta hai.

### `DFS`
Recursion (ya stack) se ek raste par jitna ho sake gehra jata hai, phir wapas aata hai.

### `visited set`
Bina visited ke cyclic graph me infinite loop ban jata hai.

## ▶️ Output

```text
BFS from 1: 1 2 3 4 5 
DFS from 1: 1 2 4 3 5 
Path 1 -> 5: true
```

## 🔑 Important Points

- BFS aur DFS dono ki time complexity O(V + E).
- Directed graph me `addEdge` sirf ek taraf (`u -> v`) jodta hai.
- Weighted graphs ke liye Dijkstra aur Bellman-Ford hote hain.
- Topological sort aur cycle detection DFS se hote hain.

## 📝 Practice

1. Graph me connected components count karo.
2. Do nodes ke beech shortest path (BFS) nikalo.
3. Directed graph me cycle detect karo.
4. Number of Islands problem solve karo.

## 🚀 Challenge

Grid par BFS lagake shortest path nikalo (S se E tak, `#` deewar).

import java.util.*;

public class GraphDemo {

    // Graph represented as an adjacency list
    static class Graph {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        void addEdge(int u, int v) {
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // undirected graph
        }

        // BFS: explore level by level using a Queue
        List<Integer> bfs(int start) {
            List<Integer> visitedOrder = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                visitedOrder.add(node);
                for (int neighbor : adjList.getOrDefault(node, List.of())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            return visitedOrder;
        }

        // DFS: explore as deep as possible using recursion (implicit stack)
        List<Integer> dfs(int start) {
            List<Integer> visitedOrder = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            dfsHelper(start, visited, visitedOrder);
            return visitedOrder;
        }

        private void dfsHelper(int node, Set<Integer> visited, List<Integer> visitedOrder) {
            visited.add(node);
            visitedOrder.add(node);
            for (int neighbor : adjList.getOrDefault(node, List.of())) {
                if (!visited.contains(neighbor)) {
                    dfsHelper(neighbor, visited, visitedOrder);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println("BFS from node 1: " + graph.bfs(1));
        System.out.println("DFS from node 1: " + graph.dfs(1));
    }
}

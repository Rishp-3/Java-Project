import java.util.*;

public class BacktrackingDemo {

    // N-Queens: place N queens on an N x N board so none attack each other
    static void solveNQueens(int n) {
        int[] columns = new int[n]; // columns[row] = column of the queen in that row
        List<List<String>> solutions = new ArrayList<>();
        placeQueens(columns, 0, n, solutions);
        System.out.println("Number of solutions for " + n + "-Queens: " + solutions.size());
        if (!solutions.isEmpty()) {
            System.out.println("First solution:");
            solutions.get(0).forEach(System.out::println);
        }
    }

    static void placeQueens(int[] columns, int row, int n, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(buildBoard(columns, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(columns, row, col)) {
                columns[row] = col; // place queen
                placeQueens(columns, row + 1, n, solutions);
                // no explicit "undo" needed - columns[row] gets overwritten next iteration
            }
        }
    }

    static boolean isSafe(int[] columns, int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = columns[prevRow];
            if (prevCol == col || Math.abs(prevCol - col) == Math.abs(prevRow - row)) {
                return false; // same column or same diagonal
            }
        }
        return true;
    }

    static List<String> buildBoard(int[] columns, int n) {
        List<String> board = new ArrayList<>();
        for (int col : columns) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < n; i++) {
                row.append(i == col ? "Q" : ".");
            }
            board.add(row.toString());
        }
        return board;
    }

    // Permutations of an array using backtracking
    static void permute(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> results) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            permute(nums, current, used, results);
            current.remove(current.size() - 1); // backtrack
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        solveNQueens(4);

        System.out.println("\nAll permutations of [1, 2, 3]:");
        List<List<Integer>> results = new ArrayList<>();
        permute(new int[]{1, 2, 3}, new ArrayList<>(), new boolean[3], results);
        results.forEach(System.out::println);
    }
}

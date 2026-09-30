public class RecursionDSA {

    // Tower of Hanoi - a classic recursion problem
    static void towerOfHanoi(int n, char from, char aux, char to) {
        if (n == 0) return;
        towerOfHanoi(n - 1, from, to, aux);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        towerOfHanoi(n - 1, aux, from, to);
    }

    // Power function using recursion with O(log n) via divide and conquer
    static long power(int base, int exponent) {
        if (exponent == 0) return 1;
        long half = power(base, exponent / 2);
        if (exponent % 2 == 0) {
            return half * half;
        }
        return half * half * base;
    }

    // Generate all subsets of a set (the power set) using recursion/backtracking
    static void generateSubsets(int[] nums, int index, java.util.List<Integer> current) {
        if (index == nums.length) {
            System.out.println(current);
            return;
        }
        // exclude the current element
        generateSubsets(nums, index + 1, current);
        // include the current element
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current);
        current.remove(current.size() - 1); // backtrack
    }

    public static void main(String[] args) {
        System.out.println("Tower of Hanoi with 3 disks:");
        towerOfHanoi(3, 'A', 'B', 'C');

        System.out.println("\n2^10 = " + power(2, 10));

        System.out.println("\nAll subsets of {1, 2, 3}:");
        generateSubsets(new int[]{1, 2, 3}, 0, new java.util.ArrayList<>());
    }
}

public class ComplexityDemo {

    // O(1) - Constant time: work doesn't depend on input size
    static int getFirst(int[] arr) {
        return arr[0];
    }

    // O(n) - Linear time: work grows directly with input size
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // O(log n) - Logarithmic time: work halves each step
    static int binarySearch(int[] sortedArr, int target) {
        int low = 0, high = sortedArr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArr[mid] == target) return mid;
            if (sortedArr[mid] < target) low = mid + 1; else high = mid - 1;
        }
        return -1;
    }

    // O(n^2) - Quadratic time: nested loops over the input
    static void printAllPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
        }
        System.out.println();
    }

    // O(2^n) - Exponential time: naive recursive Fibonacci
    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 9, 2};
        int[] sorted = {1, 2, 3, 5, 8, 9};

        System.out.println("O(1) getFirst: " + getFirst(arr));
        System.out.println("O(n) linearSearch(8): " + linearSearch(arr, 8));
        System.out.println("O(log n) binarySearch(8): " + binarySearch(sorted, 8));
        System.out.print("O(n^2) printAllPairs: ");
        printAllPairs(new int[] {1, 2, 3});
        System.out.println("O(2^n) fibonacci(10): " + fibonacci(10));

        System.out.println("\nBig-O describes how RUNTIME GROWS as input size grows,");
        System.out.println("not the exact time - it helps compare algorithm efficiency.");
    }
}

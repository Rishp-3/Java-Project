import java.util.Arrays;

public class ArraySearching {

    // Linear search: check every element one by one. Works on unsorted arrays.
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary search: array MUST be sorted. Repeatedly halves the search range.
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] unsorted = {45, 12, 78, 3, 90, 23};

        int index = linearSearch(unsorted, 78);
        System.out.println("Linear search for 78 -> index " + index);

        int[] sorted = {3, 12, 23, 45, 78, 90};
        int result = binarySearch(sorted, 45);
        System.out.println("Binary search for 45 -> index " + result);

        // Built-in binary search from java.util.Arrays
        System.out.println("Arrays.binarySearch for 90 -> index " + Arrays.binarySearch(sorted, 90));

        System.out.println("Searching for 100 (not present) -> " + linearSearch(unsorted, 100));
    }
}

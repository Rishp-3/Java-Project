import java.util.Arrays;

public class ArrayProblems {

    // Find the largest element
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int n : arr) {
            if (n > max) max = n;
        }
        return max;
    }

    // Reverse an array in place
    static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Remove duplicates from a sorted array, returns the new logical length
    static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int writeIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[writeIndex - 1]) {
                arr[writeIndex] = arr[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }

    // Second largest element
    static int secondLargest(int[] arr) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > max) {
                second = max;
                max = n;
            } else if (n > second && n != max) {
                second = n;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 4};
        System.out.println("Max: " + findMax(arr));
        System.out.println("Second largest: " + secondLargest(arr));

        reverse(arr);
        System.out.println("Reversed: " + Arrays.toString(arr));

        int[] sortedWithDupes = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(sortedWithDupes);
        System.out.println("After removing duplicates: " +
            Arrays.toString(Arrays.copyOf(sortedWithDupes, newLength)));
    }
}

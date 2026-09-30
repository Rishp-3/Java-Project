import java.util.Arrays;

public class ArraysDemo {

    // Rotate an array to the right by k positions
    static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Find the maximum sum of a contiguous subarray (Kadane's algorithm)
    static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // Move all zeros in an array to the end, keeping order of other elements
    static void moveZerosToEnd(int[] arr) {
        int insertPos = 0;
        for (int num : arr) {
            if (num != 0) {
                arr[insertPos++] = num;
            }
        }
        while (insertPos < arr.length) {
            arr[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        rotateRight(arr1, 2);
        System.out.println("Rotated right by 2: " + Arrays.toString(arr1));

        int[] arr2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum: " + maxSubArraySum(arr2));

        int[] arr3 = {0, 1, 0, 3, 12};
        moveZerosToEnd(arr3);
        System.out.println("Zeros moved to end: " + Arrays.toString(arr3));
    }
}

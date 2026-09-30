import java.util.Arrays;

public class SortingSearchingDemo {

    // Merge Sort - divide and conquer, O(n log n), stable
    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    // Quick Sort - divide and conquer using a pivot, O(n log n) average case
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    // Binary Search - O(log n), array must be sorted
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1; else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr1, 0, arr1.length - 1);
        System.out.println("Merge sorted: " + Arrays.toString(arr1));

        int[] arr2 = {10, 7, 8, 9, 1, 5};
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println("Quick sorted: " + Arrays.toString(arr2));

        System.out.println("Binary search for 43 in merge-sorted array: " + binarySearch(arr1, 43));
    }
}

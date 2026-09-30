import java.util.Arrays;

public class ArraySorting {

    // Bubble sort: repeatedly swap adjacent elements if they are in the wrong order
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection sort: repeatedly find the minimum and place it at the front
    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {64, 25, 12, 22, 11};
        bubbleSort(arr1);
        System.out.println("Bubble sorted: " + Arrays.toString(arr1));

        int[] arr2 = {29, 10, 14, 37, 13};
        selectionSort(arr2);
        System.out.println("Selection sorted: " + Arrays.toString(arr2));

        // Built-in sort
        int[] arr3 = {5, 3, 8, 1, 9};
        Arrays.sort(arr3);
        System.out.println("Arrays.sort: " + Arrays.toString(arr3));

        // Sorting in descending order using a wrapper Integer array
        Integer[] arr4 = {5, 3, 8, 1, 9};
        Arrays.sort(arr4, (a, b) -> b - a);
        System.out.println("Descending: " + Arrays.toString(arr4));
    }
}

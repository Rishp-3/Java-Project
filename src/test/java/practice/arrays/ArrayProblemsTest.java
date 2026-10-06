package practice.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayProblemsTest {
    @Test void reverse() {
        int[] in = {1, 2, 3};
        assertArrayEquals(new int[] {3, 2, 1}, ArrayProblems.reverse(in));
        assertArrayEquals(new int[] {1, 2, 3}, in);
        assertArrayEquals(new int[0], ArrayProblems.reverse(new int[0]));
    }
    @Test void secondLargest() {
        assertEquals(4, ArrayProblems.secondLargest(new int[] {1, 5, 4, 5, 2}));
        assertEquals(-2, ArrayProblems.secondLargest(new int[] {-1, -2, -3}));
        assertThrows(IllegalArgumentException.class, () -> ArrayProblems.secondLargest(new int[] {7, 7}));
    }
    @Test void rotate() {
        assertArrayEquals(new int[] {4, 5, 1, 2, 3}, ArrayProblems.rotateRight(new int[] {1, 2, 3, 4, 5}, 2));
        assertArrayEquals(new int[] {5, 1, 2, 3, 4}, ArrayProblems.rotateRight(new int[] {1, 2, 3, 4, 5}, 6));
        assertArrayEquals(new int[] {2, 3, 1}, ArrayProblems.rotateRight(new int[] {1, 2, 3}, -1));
    }
    @Test void binarySearch() {
        int[] a = {1, 3, 5, 7, 9, 11};
        assertEquals(3, ArrayProblems.binarySearch(a, 7));
        assertEquals(0, ArrayProblems.binarySearch(a, 1));
        assertEquals(-1, ArrayProblems.binarySearch(a, 4));
        assertEquals(-1, ArrayProblems.binarySearch(new int[0], 4));
    }
    @Test void twoSum() {
        assertArrayEquals(new int[] {0, 1}, ArrayProblems.twoSum(new int[] {2, 7, 11, 15}, 9));
        assertEquals(0, ArrayProblems.twoSum(new int[] {1, 2}, 10).length);
    }
    @Test void transpose() {
        assertArrayEquals(new int[][] {{1, 4}, {2, 5}, {3, 6}}, ArrayProblems.transpose(new int[][] {{1, 2, 3}, {4, 5, 6}}));
    }
    @Test void bubbleSort() {
        assertArrayEquals(new int[] {1, 2, 3, 5, 8}, ArrayProblems.bubbleSort(new int[] {5, 2, 8, 1, 3}));
    }
}

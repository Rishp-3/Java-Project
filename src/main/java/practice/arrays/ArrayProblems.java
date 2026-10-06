package practice.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Module 04 - Arrays: 1D/2D arrays, searching, sorting, classic problems. */
public final class ArrayProblems {
    private ArrayProblems() {}

    /** Problem 1: return a reversed copy (input is not modified). */
    public static int[] reverse(int[] a) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) r[a.length - 1 - i] = a[i];
        return r;
    }

    /** Problem 2: second largest DISTINCT value, or throw if there isn't one. */
    public static int secondLargest(int[] a) {
        Integer first = null, second = null;
        for (int x : a) {
            if (first == null || x > first) { second = first; first = x; }
            else if (x != first && (second == null || x > second)) second = x;
        }
        if (second == null) throw new IllegalArgumentException("need at least two distinct values");
        return second;
    }

    /** Problem 3: rotate right by k positions (k may be larger than the length). */
    public static int[] rotateRight(int[] a, int k) {
        if (a.length == 0) return new int[0];
        int[] r = new int[a.length];
        int shift = Math.floorMod(k, a.length);
        for (int i = 0; i < a.length; i++) r[(i + shift) % a.length] = a[i];
        return r;
    }

    /** Problem 4: binary search in a sorted array; returns index or -1. */
    public static int binarySearch(int[] sorted, int target) {
        int lo = 0, hi = sorted.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sorted[mid] == target) return mid;
            if (sorted[mid] < target) lo = mid + 1; else hi = mid - 1;
        }
        return -1;
    }

    /** Problem 5: indices of two numbers adding up to target, or an empty array. */
    public static int[] twoSum(int[] a, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            Integer j = seen.get(target - a[i]);
            if (j != null) return new int[] {j, i};
            seen.put(a[i], i);
        }
        return new int[0];
    }

    /** Problem 6: transpose a rectangular 2D array. */
    public static int[][] transpose(int[][] m) {
        if (m.length == 0) return new int[0][0];
        int[][] t = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++) t[j][i] = m[i][j];
        return t;
    }

    /** Problem 7: bubble sort (returns a sorted copy). */
    public static int[] bubbleSort(int[] a) {
        int[] r = Arrays.copyOf(a, a.length);
        for (int pass = 0; pass < r.length - 1; pass++) {
            boolean swapped = false;
            for (int i = 0; i < r.length - 1 - pass; i++) {
                if (r[i] > r[i + 1]) { int t = r[i]; r[i] = r[i + 1]; r[i + 1] = t; swapped = true; }
            }
            if (!swapped) break;
        }
        return r;
    }
}

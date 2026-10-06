package practice.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/** Module 09 - Collections: List, Set, Map, Queue, Deque. */
public final class CollectionProblems {
    private CollectionProblems() {}

    /** Problem 1: word frequencies, sorted alphabetically (TreeMap). */
    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> freq = new TreeMap<>();
        for (String w : text.toLowerCase().split("\\W+")) {
            if (!w.isEmpty()) freq.merge(w, 1, Integer::sum);
        }
        return freq;
    }

    /** Problem 2: remove duplicates but keep first-seen order (LinkedHashSet). */
    public static <T> List<T> dedupe(List<T> items) {
        return new ArrayList<>(new LinkedHashSet<>(items));
    }

    /** Problem 3: balanced brackets using a Deque as a stack. */
    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(', '[', '{' -> stack.push(c);
                case ')', ']', '}' -> {
                    if (stack.isEmpty()) return false;
                    char open = stack.pop();
                    if ((c == ')' && open != '(') || (c == ']' && open != '[') || (c == '}' && open != '{')) return false;
                }
                default -> { }
            }
        }
        return stack.isEmpty();
    }

    /** Problem 4: group words by length (TreeMap keeps lengths sorted). */
    public static Map<Integer, List<String>> groupByLength(List<String> words) {
        Map<Integer, List<String>> groups = new TreeMap<>();
        for (String w : words) groups.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
        return groups;
    }

    /** Problem 5: k-th largest element using a min-heap of size k (PriorityQueue). */
    public static int kthLargest(int[] nums, int k) {
        if (k < 1 || k > nums.length) throw new IllegalArgumentException("k out of range");
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : nums) {
            heap.offer(n);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }

    /** Problem 6: elements present in both lists, without duplicates, in first-list order. */
    public static <T> List<T> intersection(List<T> a, List<T> b) {
        LinkedHashSet<T> result = new LinkedHashSet<>(a);
        result.retainAll(new java.util.HashSet<>(b));
        return new ArrayList<>(result);
    }
}

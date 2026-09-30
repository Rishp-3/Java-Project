import java.util.PriorityQueue;
import java.util.Collections;

public class HeapDemo {

    // Find the K largest elements using a min-heap of size K
    static java.util.List<Integer> findKLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove the smallest, keeping only the k largest so far
            }
        }
        return new java.util.ArrayList<>(minHeap);
    }

    // Find the median of a running stream of numbers using two heaps
    static class MedianFinder {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // smaller half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // larger half

        void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll()); // balance: move the largest of the smaller half over

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println("3 largest elements: " + findKLargest(arr, 3));

        MedianFinder medianFinder = new MedianFinder();
        int[] stream = {5, 15, 1, 3};
        for (int num : stream) {
            medianFinder.addNum(num);
            System.out.println("After adding " + num + ", median = " + medianFinder.findMedian());
        }

        // Heap sort using PriorityQueue (min-heap gives sorted order when polled)
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : arr) heap.offer(num);
        StringBuilder sorted = new StringBuilder();
        while (!heap.isEmpty()) sorted.append(heap.poll()).append(" ");
        System.out.println("Heap sort result: " + sorted.toString().trim());
    }
}

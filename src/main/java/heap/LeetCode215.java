package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num: nums) {
            maxHeap.add(num);
        }
        // for (int i = 0; i < k-1; i++) {
        //     maxHeap.poll();
        // }
        while (k-- > 1) {
            maxHeap.poll();
        }
        return maxHeap.poll();

        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // for (int num: nums) {
        //     if (minHeap.size() > k) {
        //         minHeap.poll();
        //     }
        //     minHeap.add(num);
        // }
        // return minHeap.poll();
    }

}

package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        minHeap.add(10);
        minHeap.add(8);
        minHeap.add(9);
        minHeap.add(11);
        minHeap.add(2);
        // [2, 8, 9, 11, 10]

        maxHeap.add(10);
        maxHeap.add(8);
        maxHeap.add(9);
        maxHeap.add(11);
        maxHeap.add(2);
        // [11, 10, 9, 8, 2]

        // 获取堆顶元素
        Integer peek = minHeap.peek();
        Integer peek1 = maxHeap.peek();


        //删除堆顶元素
        Integer poll = minHeap.poll();
        Integer poll1 = maxHeap.poll();

        minHeap.size();
        maxHeap.size();

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }



    }
}

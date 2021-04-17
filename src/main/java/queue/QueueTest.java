package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {
        // create a queue
        Queue<Integer> queue = new LinkedList<>();

        // add element
        // Time Complexity: O(1)
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // [1, 2, 3]

        // get the head of queue
        // Time Complexity: O(1)
        int element = queue.peek();
        // element = 1

        // remove the head of queue
        // Time Complexity: O(1)
        int temp = queue.poll();
        // int temp = queue.remove();
        // poll(): 如果队列为空时返回null
        // remove(): 如果队列为空时会抛出异常
        // temp = 1
        // [2, 3]

        // queue is empty?
        // Time Complexity: O(1)
        boolean isEmpty = queue.isEmpty();;
        // false

        // the length of queue
        // Time Complexity: O(1)
        int length = queue.size();
        // 2

        while (!queue.isEmpty()) {
            int temp2 = queue.poll();
            System.out.println(temp2);
        }

        queue.remove();
    }
}

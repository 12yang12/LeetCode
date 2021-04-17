package queue;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
public class LeetCode933 {

    //public RecentCounter() {
    //}
    private  Queue<Integer> queue ;

    public  LeetCode933() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && (t - queue.peek() > 3000)) {
            queue.poll();
        }
        return queue.size();
    }
}

package set;

import java.util.Arrays;

public class LeetCode705 {

    /**
     * Initialize your data structure here.
     */
    //public MyHashSet() {
    //}

    private int[] array = new int[1000000];

    public LeetCode705() {
        Arrays.fill(array, 0);
    }

    public void add(int key) {
        array[key] = 1;
    }

    public void remove(int key) {
        array[key] = 0;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return array[key] == 1;
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

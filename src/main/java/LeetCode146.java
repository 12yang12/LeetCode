import java.util.LinkedHashMap;

public class LeetCode146 {

}

class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将key变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            // 将key变为最近使用
            makeRecently(key);
            return;
        }
        if (cache.size() >= capacity) {
            // 链表头部就是最久未使用的key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的key添加到链表尾部
        cache.put(key, value);
    }

    private void makeRecently(int key) {
        int value = cache.get(key);
        // 删除key,重新插入到队尾
        cache.remove(key);
        cache.put(key, value);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
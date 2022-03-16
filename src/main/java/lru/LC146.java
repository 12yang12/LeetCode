package lru;

import java.util.LinkedHashMap;

public class LC146 {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache);
        cache.remove(1);
        System.out.println(cache);
        cache.put(5, 5);
        System.out.println(cache);
    }
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

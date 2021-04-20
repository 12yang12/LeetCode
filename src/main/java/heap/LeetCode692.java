package heap;

import java.util.*;

public class LeetCode692 {

// 计算每个单词的频率，然后将其添加到存储到大小为 k 的小根堆中。
// 它将频率最小的候选项放在堆的顶部。(频率最小 + 单词字母最大) a<b
// 最后，我们从堆中弹出最多 k 次，并反转结果，就可以得到前 k 个高频单词。

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (w1, w2) -> map.get(w1).equals(map.get(w2))
                        ? w2.compareTo(w1) : map.get(w1) - map.get(w2));

        for (String word : map.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("a".compareTo("b"));
    }
}

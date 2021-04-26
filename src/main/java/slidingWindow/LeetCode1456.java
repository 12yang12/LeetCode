package slidingWindow;

import java.util.HashSet;

public class LeetCode1456 {

    public int maxVowels(String s, int k) {
        int res;
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i) )){
                count++;
            }
        }
        res = count;
        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i))){
                count++;
            }
            if (set.contains(s.charAt(i-k))){
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}

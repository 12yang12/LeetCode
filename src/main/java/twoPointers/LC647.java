package twoPointers;

/**
 * 647. 回文子串
 *
 * https://www.programmercarl.com/0647.%E5%9B%9E%E6%96%87%E5%AD%90%E4%B8%B2.html#%E5%8F%8C%E6%8C%87%E9%92%88%E6%B3%95
 */
public class LC647 {

    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += extend(s, i, i, s.length()); // 以i为中心
            result += extend(s, i, i + 1, s.length()); // 以i和i+1为中心
        }

        return result;
    }

    int extend(String s, int i, int j, int length) {
        int res = 0;
        while (i >= 0 && j < length && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            res++;
        }
        return res;
    }
}

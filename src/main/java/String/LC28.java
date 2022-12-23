package String;

public class LC28 {

    /**
     * 基于窗口滑动的算法
     * <p>
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     * 注：n为haystack的长度，m为needle的长度
     */
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        if (m == 0) {
            return 0;
        }

        int n = haystack.length();
        if (n < m) {
            return -1;
        }

        int i = 0;
        int j = 0;
        while (i < n - m + 1) {
            // 找到首字母相等
            while (i < n && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }

            // 没有首字母相等的
            if (i == n) {
                return -1;
            }

            // 遍历后续字符，判断是否相等
            i++;
            j++;
            while (i < n && j < m && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                // 找到
                return i - j;
            } else {
                // 未找到
                i -= j - 1;
                j = 0;
            }
        }
        return -1;
    }
}

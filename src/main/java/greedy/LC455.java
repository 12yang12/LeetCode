package greedy;

import java.util.Arrays;

public class LC455 {

    // 时间复杂度：O(nlogn)
    // 空间复杂度：O(1)
    // 大饼干喂给胃口大的

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index = s.length - 1;
        int result = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && g[i] <= s[index]) {
                index--;
                result++;
            }
        }

        return result;
    }
}

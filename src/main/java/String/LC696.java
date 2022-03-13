package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 696. 计数二进制子串
 */
public class LC696 {

    public int countBinarySubstrings(String s) {
        List<Integer> countList = new ArrayList<>();
        int n = s.length(), index = 0;

        while (index < n) {
            char c = s.charAt(index);
            int count = 0;

            while (index < n && s.charAt(index) == c) {
                count++;
                index++;
            }
            countList.add(count);
        }

        int ans = 0;
        for (int i = 1; i < countList.size(); i++) {
            ans += Math.min(countList.get(i), countList.get(i - 1));
        }

        return ans;
    }
}

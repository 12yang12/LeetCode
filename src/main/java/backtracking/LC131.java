package backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class LC131 {

    private List<List<String>> result = new ArrayList<>();
    private Deque<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);

        return result;
    }

    private void backtracking(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                // 获取在s中[startIndex,i]的子串
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}

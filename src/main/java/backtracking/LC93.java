package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC93 {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result;
        }

        backtracking(s, 0, 0);
        return result;
    }

    /**
     * @param s
     * @param startIndex 搜索的起始位置
     * @param pointNum   添加逗点的数量
     */

    void backtracking(String s, int startIndex, int pointNum) {
        // 逗点数量为3时，分隔结束
        if (pointNum == 3) {
            // 判断第四段子字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 判断 [startIndex,i] 这个区间的子串是否合法
            if (isValid(s, startIndex, i)) {
                //在s的后面插⼊⼀个逗点
                s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
                pointNum++;
                // 插入逗点之后下一个子串的起始位置为i+2
                backtracking(s, i + 2, pointNum);
                pointNum--;
                // 回溯删掉逗点
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }


    /**
     * 判断字符串s在左闭右闭区间[start, end]所组成的数字是否合法
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到非数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            // 如果大于255不合法
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }

        return true;
    }
}

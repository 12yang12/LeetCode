package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */
public class LC17 {

    private String[] numString = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> resultList = new ArrayList<>();
    private StringBuilder string = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return resultList;
        }

        backtracking(digits, 0);

        return resultList;
    }

    private void backtracking(String digits, int index) {
        if (index == digits.length()) {
            resultList.add(string.toString());
            return;
        }

        // 将index指向的数字转为int
        int digit = digits.charAt(index) - '0';
        // 取数字对应的字符集
        String letters = numString[digit];
        for (int i = 0; i < letters.length(); i++) {
            string.append(letters.charAt(i));
            backtracking(digits, index + 1);
            string.deleteCharAt(string.length() - 1);
        }
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC22 {


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, result, 0, 0, "");
        return result;
    }

    private void backtracking(int n, List<String> result, int left, int right, String s) {
        if (right > left) {
            return;
        }

        if (left == right && left == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            backtracking(n, result, left + 1, right, s + "(");
        }

        if (right < left) {
            backtracking(n, result, left, right + 1, s + ")");
        }
    }


}


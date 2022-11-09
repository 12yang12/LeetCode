package dynamicProgramming;

public class LeetCode509 {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int pre = 0;
        int cur = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = pre + cur;
            pre = cur;
            cur = res;
        }
        return res;
    }
}

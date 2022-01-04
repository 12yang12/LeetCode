package greedy;

import java.util.Arrays;

public class LC135 {

    /**
     * 本题我采用了两次贪心的策略：
     *
     * 一次是从左到右遍历，只比较右边孩子评分比左边大的情况。
     * 一次是从右到左遍历，只比较左边孩子评分比右边大的情况。
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        // 从前向后
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        // 从后向前
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        int result = 0;
        for (int i : candy) {
            result += i;
        }

        return result;
    }

}

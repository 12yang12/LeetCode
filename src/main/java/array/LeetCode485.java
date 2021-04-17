package array;

/**
 * 485. 最大连续 1 的个数
 *      给定一个二进制数组， 计算其中最大连续 1 的个数
 * 示例：
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 * 提示：
 * 输入的数组只包含0 和 1 .
 * 输入数组的长度是正整数，且不超过 10,000.
 *
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * @author Yang
 */

public class LeetCode485 {

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return  0;
        }

        int count = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                result = Math.max(count, result);
                count = 0;
            }
        }

        return Math.max(count, result);
    }

    public static void main(String[] args) {
        int result = new LeetCode485().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1});
        System.out.println(result);
    }
}

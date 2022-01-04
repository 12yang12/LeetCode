package greedy;

import java.util.stream.IntStream;

public class LC1005 {

    /**
     * 那么本题的解题步骤为：
     * <p>
     * 第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
     * 第二步：从前向后遍历，遇到负数将其变为正数，同时K--
     * 第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
     * 第四步：求和
     *
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 第一步 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums).boxed()
                .sorted(((o1, o2) -> Math.abs(o2) - Math.abs(o1)))
                .mapToInt(Integer::intValue).toArray();

        // 第二步
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                k--;
                nums[i] = -nums[i];
            }
        }
        // 第三步
        if (k % 2 == 1) {
            nums[nums.length - 1] = -nums[nums.length - 1];
        }
        // 第四步
        int result = 0;
        for (int i : nums) {
            result += i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, 2, 3};
        int k = 3;
        int res = new LC1005().largestSumAfterKNegations(nums, k);
        System.out.println(res);
    }
}

package greedy;

public class LC53 {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            //  取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count > result) {
                result = count;
            }
            // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            if (count < 0) {
                count = 0;
            }
        }

        return result;
    }
}

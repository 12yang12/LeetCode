package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 剪枝处理
            if (nums[i] > target && nums[i] >= 0) {
                break;
            }

            // 对nums[i]去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // 2级剪枝处理
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) {
                    break;
                }

                // 对nums[j]去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        resultList.add(list);

                        // 对nums[left]和nums[right]去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    }
                }
            }
        }
        return resultList;
    }
}

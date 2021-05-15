package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        // 扩展法/暴力法
        // Time Complexity: O(N*2^N)
        // Space Complexity: O(N*2^N)
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> subset = new ArrayList<>();
            for (List<Integer> res : result) {
                ArrayList<Integer> temp = new ArrayList<>(res);
                temp.add(num);
                subset.add(temp);
            }
            result.addAll(subset);
        }

        return result;
    }


    public List<List<Integer>> subsets2(int[] nums) {
        // Backtracking回溯法
        // Time Complexity: O(N*2^N)
        // Space Complexity: O(N*2^N)
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i++) {
            backtracking(nums, result, i, 0, new ArrayList<>());
        }

        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, int length, int index, List<Integer> subset) {
        if (subset.size() == length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtracking(nums, result, length, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsets3(int[] nums) {
        // DFS
        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, result, 0, new ArrayList<>());

        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, int index, ArrayList<Integer> subset) {

        result.add(new ArrayList<>(subset));
        if (index == nums.length ) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, result, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new LeetCode78().subsets3(new int[]{1,2,3});
        for (List<Integer> r:res){
            System.out.println(r);
        }
    }
}

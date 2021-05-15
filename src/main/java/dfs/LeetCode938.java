package dfs;


import java.util.LinkedList;
import java.util.Queue;

public class LeetCode938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        // DFS
        if (root == null) {
            return 0;
        }

        int lectSum = rangeSumBST(root.left, low, high);
        int rightSum = rangeSumBST(root.right, low, high);
        int result = lectSum + rightSum;

        if (root.val >= low && root.val <= high) {
            result += root.val;
        }

        return result;
    }


    public int rangeSumBST2(TreeNode root, int low, int high) {
        // BFS
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.val >= low && currentNode.val <= high) {
                result += currentNode.val;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return result;
    }

}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

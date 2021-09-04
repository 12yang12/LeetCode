package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 */
public class LC515 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}

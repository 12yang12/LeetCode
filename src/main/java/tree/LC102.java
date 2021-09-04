package tree;

/**
 * 102. 二叉树的层序遍历
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {
    public static void main(String[] args) {
        // 创建队列
        Queue<Integer> queue = new LinkedList<>();
        // 添加元素
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue);

        // 返回队列首元素
        System.out.println(queue.peek());

        // 删除队列元素
        queue.poll();
        System.out.println(queue);

        queue.remove();
        System.out.println(queue);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int queueSize = queue.size();

            while (queueSize > 0) {
                TreeNode node = queue.poll();
                itemList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                queueSize--;
            }

            resultList.add(itemList);
        }

        return resultList;
    }
}

package tree;

import java.util.ArrayList;
import java.util.List;

public class LC257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);

        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);

        // 叶子结点
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                stringBuilder.append(paths.get(i)).append("->");
            }
            stringBuilder.append(paths.get(paths.size() - 1));
            res.add(stringBuilder.toString());
            return;
        }

        if (root.left != null) {
            traversal(root.left, paths, res);
            // 回溯
            paths.remove(paths.size() - 1);
        }

        if (root.right != null) {
            traversal(root.right, paths, res);
            // 回溯
            paths.remove(paths.size() - 1);
        }
    }
}

package tree;

import java.util.ArrayList;

/**
 * 501. 二叉搜索树中的众数
 */
public class LC501 {

    private int maxCount;
    private int count;
    private ArrayList<Integer> resultList;
    private TreeNode pre;

    public int[] findMode(TreeNode root) {
        resultList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;

        searchBST(root);

        int[] res = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }

        return res;
    }

    private void searchBST(TreeNode cur) {
        if (cur == null) {
            return;
        }

        searchBST(cur.left);

        if (pre == null || pre.val != cur.val) {
            count = 1;
        } else {
            count++;
        }

        // 更新结果以及maxCount
        if (count > maxCount) {
            resultList.clear();
            resultList.add(cur.val);
            maxCount = count;
        } else if (count ==maxCount) {
            resultList.add(cur.val);
        }
        // 更新上一个节点
        pre = cur;

        searchBST(cur.right);
    }
}

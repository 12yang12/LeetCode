package tree;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class LC106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        return traversal(0, inorder.length, inorder, 0, postorder.length, postorder);
    }

    // 中序区间：[inorderBegin, inorderEnd)，后序区间 [postorderBegin, postorderEnd) 左闭右开
    private TreeNode traversal(int inorderBegin, int inorderEnd, int[] inorder, int postorderBegin, int postorderEnd, int[] postorder) {
        if (inorderEnd == inorderBegin) {
            return null;
        }

        int rootValue = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootValue);

        if (postorderEnd - postorderBegin == 1) {
            return root;
        }

        int index = inorderBegin;
        for (; index < inorderEnd; index++) {
            if (inorder[index] == rootValue) {
                break;
            }
        }

        // 切割中序数组
        // 左中序区间，左闭右开[leftInorderBegin, leftInorderEnd)
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = index;
        // 右中序区间，左闭右开[rightInorderBegin, rightInorderEnd)
        int rightInorderBegin = index + 1;
        int rightInorderEnd = inorderEnd;

        // 切割后序数组
        // 左后序区间，左闭右开[leftPostorderBegin, leftPostorderEnd)
        int leftPostorderBegin = postorderBegin;
        // 终止位置是 需要加上 中序区间的大小size
        int leftPostorderEnd = postorderBegin + index - inorderBegin;
        // 右后序区间，左闭右开[rightPostorderBegin, rightPostorderEnd)
        int rightPostorderBegin = postorderBegin + (index - inorderBegin);
        // 排除最后一个元素，已经作为节点了
        int rightPostorderEnd = postorderEnd - 1;

        root.left = traversal(leftInorderBegin, leftInorderEnd, inorder, leftPostorderBegin, leftPostorderEnd, postorder);
        root.right = traversal(rightInorderBegin, rightInorderEnd, inorder, rightPostorderBegin, rightPostorderEnd, postorder);

        return root;
    }
}

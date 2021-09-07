package tree;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class LC105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode traversal(int[] preorder, int preorderBegin, int preorderEnd, int[] inorder, int inorderBegin, int inorderEnd) {
        if (preorderEnd == preorderBegin) {
            return null;
        }

        int rootValue = preorder[preorderBegin];
        TreeNode root = new TreeNode(rootValue);

        if (preorderEnd - preorderBegin == 1) {
            return root;
        }

        int index = inorderBegin;
        for (; index < inorderEnd; index++) {
            if (inorder[index] == rootValue) {
                break;
            }
        }

        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = index;
        int rightInorderBegin = index + 1;
        int rightInorderEnd = inorderEnd;

        int leftPreorderBegin =  preorderBegin + 1;
        // 终止位置是起始位置加上中序左区间的大小size
        int leftPreorderEnd = preorderBegin + 1 + (index - inorderBegin);
        // 前序右区间, 左闭右开[rightPreorderBegin, rightPreorderEnd)
        int rightPreorderBegin = preorderBegin + 1 + (index - inorderBegin);
        int rightPreorderEnd = preorderEnd;

        root.left = traversal(preorder, leftPreorderBegin, leftPreorderEnd, inorder, leftInorderBegin, leftInorderEnd);
        root.right = traversal(preorder, rightPreorderBegin, rightPreorderEnd, inorder, rightInorderBegin, rightInorderEnd);

        return root;
    }
}

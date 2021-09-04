package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class LC116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node pre = null;
            Node cur;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    pre = deque.pollFirst();
                    cur = pre;
                } else {
                    cur = deque.pollFirst();
                    pre.next = cur;
                    pre = cur;
                }
                if (cur.left != null) {
                    deque.offerLast(cur.left);
                }
                if (cur.right != null) {
                    deque.offerLast(cur.right);
                }
            }
        }
        return root;
    }


    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

}

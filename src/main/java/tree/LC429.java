package tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelList = new ArrayList<>();
            while (size-- > 0) {
                Node node = deque.pollFirst();
                levelList.add(node.val);
                List<Node> children = node.children;
                for (int i = 0; i < children.size(); i++) {
                    deque.offerLast(children.get(i));
                }
            }
            resList.add(levelList);
        }
        return resList;
    }


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}

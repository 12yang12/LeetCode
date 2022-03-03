package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 */
public class LC234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (!list.get(left++).equals(list.get(right--))) {
                return false;
            }

        }

        return true;
    }
}

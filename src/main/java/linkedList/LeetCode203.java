package linkedList;

public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        // 哨兵节点
        ListNode sentinel  = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel ;
        while ( head != null ) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
                head = head.next;
        }
        return sentinel.next;
    }
}

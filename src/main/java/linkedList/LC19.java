package linkedList;

public class LC19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        while (n-- > 0 && fast != null) {
            fast = fast.next;
        }
        // fast再提前走一步，因为需要让slow指向删除节点的上一个节点
        fast = fast.next;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }
}

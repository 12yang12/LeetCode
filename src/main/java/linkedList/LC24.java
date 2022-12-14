package linkedList;

public class LC24 {

    public ListNode swapPairs(ListNode head) {
        // 设置一个虚拟头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.next != null) {
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp2;

            cur = cur.next.next;
        }

        return dummyHead.next;
    }
}

package linkedList;

public class LC203 {

    public ListNode removeElements(ListNode head, int val) {
        // 设置一个虚拟头结点
        ListNode dummyHead = new ListNode(0);
        // 虚拟头结点指向head，这样方面后面做删除操作
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}

package linkedList;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 * <p>
 * 解决这个问题的关键是，通过某些方式，让p1和p2能够同时到达相交节点c1。
 * 所以，我们可以让p1遍历完链表A之后开始遍历链表B，让p2遍历完链表B之后开始遍历链表A，
 * 这样相当于「逻辑上」两条链表接在了一起。如果这样进行拼接，就可以让p1和p2同时进入公共部分，
 * 也就是同时到达相交节点c1：
 */
public class LC160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
}

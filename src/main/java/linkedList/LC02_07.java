package linkedList;

public class LC02_07 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;

        // 求链表A的长度
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }

        // 求链表B的长度
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;

            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }

        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }

        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}

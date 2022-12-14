package linkedList;

public class LC707 {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    class MyLinkedList {
        private int size;
        private ListNode dummyHead;

        public MyLinkedList() {
            dummyHead = new ListNode(0);
            size = 0;
        }

        // 获取到第index个节点数值，如果index是非法数值直接返回-1
        // 注意index是从0开始的，第0个节点就是头结点
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = dummyHead.next;
            while (index-- > 0) {
                cur = cur.next;
            }
            return cur.val;
        }

        // 在链表最前面插入一个节点，插入完成后，新插入的节点为链表的新的头结点
        public void addAtHead(int val) {
            ListNode newNode  = new ListNode(val);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
            size++;
        }

        // 在链表最后面添加一个节点
        public void addAtTail(int val) {
            ListNode newNode  = new ListNode(val);
            ListNode cur = dummyHead;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
            size++;
        }


        // 在第index个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        // 如果index 等于链表的长度，则说明是新插入的节点为链表的尾结点
        // 如果index大于链表的长度，则返回空
        // 如果index小于0，则置为0，作为链表的新头节点。
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }

            ListNode cur = dummyHead;
            while (index-- > 0) {
                cur = cur.next;
            }
            ListNode newNode  = new ListNode(val);
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        }

        // 删除第index个节点，如果index 大于等于链表的长度，直接return，注意index是从0开始的
        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }
            ListNode cur = dummyHead;
            while (index-- > 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

}

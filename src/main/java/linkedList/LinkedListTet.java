package linkedList;

import java.util.LinkedList;

public class LinkedListTet {

    public static void main(String[] args) {
        // create a linkedList
        LinkedList<Integer> linkedList = new LinkedList<>();

        // add element
        // Time Complexity: O(1)
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        // access element
        // Time Complexity: O(N)
        // public E get(int index)
        int element = linkedList.get(1);
        int firstElement = linkedList.getFirst();
        int lastElement = linkedList.getLast();
        // [1, 2, 3]
        // element = 2, firstElement = 1, lastElement = 3

        // search element
        // Time Complexity: O(N)
        int index = linkedList.indexOf(1);

        // update element
        // Time Complexity: O(N)
        // public E set(int index, E element)
        linkedList.set(0, 100);

        // remove element
        // Time Complexity: O(N)
        // 删除指定索引下的元素 public E remove(int index)
        linkedList.remove(1);
        // [1, 3]

        // length
        // Time Complexity: O(1)
        int length = linkedList.size();
    }

}

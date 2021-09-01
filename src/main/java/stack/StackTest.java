package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackTest {

    public static void main(String[] args) {
        // create a stack
        Deque<Integer> stack = new ArrayDeque<>();
        // add element
        // time complexity: O(1)
        stack.add(1);
        stack.add(2);
        stack.add(3);
        // stack = [1, 2, 3]
        System.out.println(stack);

        // get the top of stack
        // time complexity: O(1)
        int top = stack.peekLast();
        // top=3

        // remove the top of stack
        // time complexity: O(1)
        // removeLast() stack为空时会抛异常NoSuchElementException
        int top1 = stack.removeLast();
        // pollLast() stack为空时返回null
        System.out.println(stack);

        int top2 = stack.pollLast();

        // stack length
        int length = stack.size();

        // stack is empty?
        boolean isEmpty = stack.isEmpty();

        // Iterate a stack
        // time complexity: O(N)
        while (!stack.isEmpty()) {
            int element = stack.removeLast();
            System.out.println(element);
        }

    }
}

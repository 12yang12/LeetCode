package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列
 * 给定pushed和popped两个序列，每个序列中的值都不重复，
 * 只有当它们可能是在最初空栈上进行的推入 push和弹出 pop操作序列的结果时，返回 true；否则，返回 false。
 */

public class LC946 {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        System.out.println(stack);
        System.out.println(stack.peekLast());
        System.out.println(stack);
        System.out.println();

        System.out.println(stack.pollLast());
        System.out.println(stack);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        int length = pushed.length;

        for (int element : pushed) {
            stack.add(element);

            while (!stack.isEmpty() && index < length && stack.peekLast() == popped[index]) {
                stack.pollLast();
                index++;
            }
        }

        return stack.isEmpty();
    }
}
package stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackTest {

    public static void main(String[] args) {
        // 创建栈
        // Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stack = new LinkedList<>();

        // 压栈 ,尾插
        stack.add(1);
        stack.add(2);
        stack.addLast(3);
        System.out.println(stack);

        // 获取栈顶元素
        System.out.println(stack.peekLast());

        // 出栈
        while (!stack.isEmpty()) {
            // stack.pollLast();
            stack.removeLast();
            System.out.println(stack);
        }

        // stack length
        int length = stack.size();
    }
}

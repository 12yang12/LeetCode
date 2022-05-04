package stack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
 */
public class LC232 {

}

class MyQueue {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;
    private int front;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        return stack2.empty() ? front : stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.empty();
    }
}
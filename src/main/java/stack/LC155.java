package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class LC155 {

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> topStack;

    public MinStack() {
        stack = new LinkedList<>();
        topStack = new LinkedList<>();
        topStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        topStack.push(Math.min(topStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        topStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return topStack.peek();
    }
}
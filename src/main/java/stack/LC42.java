package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class LC42 {

    public int trap(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()])
                        - height[top];
                ans += distance * boundedHeight;
            }
            stack.push(current++);
        }

        return ans;
    }
}

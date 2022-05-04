package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. 每日温度
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，
 * 其中answer[i]是指在第i天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0来代替。
 */
public class LC739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }
}

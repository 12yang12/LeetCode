package stack;

import java.util.*;


public class LeetCode20 {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(8);
        map.put('(',')');
        map.put('[', ']');
        map.put('{', '}');

        Deque<Character> stack = new LinkedList<>();
        for (char c: s.toCharArray()) {
            // 左括号
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                // 右括号
                if (stack.isEmpty() || !map.get(stack.pop()).equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode20().isValid("{}"));
    }
}

package y25.level1;

import java.util.Stack;

public class P148 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}

package y25.leetcode.week5;

import java.util.ArrayList;
import java.util.List;

public class P921 {
    public int minAddToMakeValid(String s) {
        List<Character> stack = new ArrayList<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') stack.add(c);
            else if (c == ')') {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.remove(stack.size() - 1);
                }
            };
        }
        return count + stack.size();
    }
}

package y25.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P157 {
    public int solution(String s) {
        int answer = 0;

        List<Character> sList = new ArrayList<>();
        for (char c: s.toCharArray()) {
            sList.add(c);
        }

        for (int i = 0; i < sList.size(); i++) {
            if (isCollect(sList)) answer++;
            sList.add(sList.remove(0));
        }

        return answer;
    }

    public boolean isCollect(List<Character> list) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            char bracket = list.get(i);
            if (stack.isEmpty()) {
                if (bracket == ']' || bracket == ')' || bracket == '}')
                    return false;
                stack.push(bracket);
                continue;
            }
            if (bracket == ')') {
                if (stack.pop() != '(') return false;
            } else if (bracket == ']') {
                if (stack.pop() != '[') return false;
            } else if (bracket == '}') {
                if (stack.pop() != '{') return false;
            } else {
                stack.push(bracket);
            }
        }
        return stack.isEmpty();
    }
}

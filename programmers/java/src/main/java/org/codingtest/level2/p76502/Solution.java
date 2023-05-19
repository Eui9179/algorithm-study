package org.codingtest.level2.p76502;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        new Solution().solution("}]()[{");
    }
    public int solution(String s) {
        int answer = 0;
        int cycle = s.length();

        for (int i = 0; i < cycle; i++) {
            if (check(s)) {
                answer += 1;
            }
            s = moveLeft(s);
        }

        return answer;
    }

    public String moveLeft(String s) {
        return s.substring(1) + s.charAt(0);
    }

    public boolean check(String s) {
        String[] strings = s.split("");
        Stack<String> stack = new Stack<>();

        for (String str : strings) {
            if (!isInsert(stack, str)) return false;
            if (isClose(str)) {
                if (!isPair(stack.peek(), str)) return false;
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        return stack.isEmpty();
    }

    public String resolvePair(String s) {
        switch (s) {
            case "}" -> {
                return "{";
            }
            case "]" -> {
                return "[";
            }
            case ")" -> {
                return "(";
            }
            default -> {
                return s;
            }
        }
    }

    public boolean isInsert(Stack<String> stack, String s) {
        if (stack.isEmpty()) {
            return !(s.equals("}") || s.equals("]") || s.equals(")"));
        }
        return true;
    }

    public boolean isPair(String open, String close) {
        return open.equals(resolvePair(close));
    }

    public boolean isClose(String s) {
        return s.equals("}") || s.equals("]") || s.equals(")");
    }
}
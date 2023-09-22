package org.codingtest.inflearn.ds.p2;

import java.util.*;

class Solution {
    // 3(a20(30b))ef
    public String solution(String s) {
        String answer = "";

        Stack<String> stack = new Stack<>();

        for (String str : s.split("")) {
            // 괄호가 닫힐 때, 열린 괄호 + 숫자까지 계산 후 다시 stack에 넣음
            if (str.equals(")")) { // 닫힌 괄호를 만나면 지금까지 스택에 있는 값 전부 계산
                String tmp = "";
                while (!stack.peek().equals("(")) { // 열린 괄호를 만날 때까지
                    String pop = stack.pop();
                    if (isDigit(pop)) { // 숫자일 경우
                        String digit = String.valueOf(pop);
                        while (!stack.isEmpty() && isDigit(stack.peek())) {
                            // 뒤도 계속 숫자일 경우
                            // e.g. 30처럼 2자리 이상 숫자일 경우
                            digit = stack.pop() + digit;
                        }
                        tmp = tmp.repeat(Integer.parseInt(digit)); // 그 숫자만큼 반복
                    } else {
                        tmp = pop + tmp; // 문자일 경우 그냥 꺼냄
                    }
                }
                stack.pop(); // ( 괄호 제거
                String digit = ""; // 괄호 밖에 숫자가 있을 경우
                while (!stack.isEmpty() && isDigit(stack.peek())) {
                    digit = stack.pop() + digit;
                }

                if (!digit.isEmpty()) { // 숫자가 있는 경우 반복
                    tmp = tmp.repeat(Integer.parseInt(digit));
                }
                stack.add(tmp);
            } else {
                stack.add(str);
            }
        }

        while (!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }

        return answer;
    }

    private boolean isDigit(String digit) {
        try {
            Integer.valueOf(digit);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("3(a20(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}

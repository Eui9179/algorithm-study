package org.codingtest.level0.p120834;

import java.util.Arrays;

class Solution {
    public String solution(int age) {
        String answer = "";
        String ageStr = String.valueOf(age);
        for (char c : ageStr.toCharArray()) {
            answer += (char)(c + '1');
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((int)'1');
    }
}
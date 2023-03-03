package org.codingtest.level0.p120907;

import java.util.Arrays;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[] splitq;
        for (int i = 0; i < quiz.length; i++) {
            splitq = quiz[i].split(" ");
            answer[i] = Integer.parseInt(splitq[0])
                    + (Integer.parseInt(splitq[2])) * (splitq[1].equals("-") ? -1 : 1)
                    == Integer.parseInt(splitq[4]) ? "O" : "X";
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"-11 + -11 = 0"})));
    }
}
package org.codingtest.level0.p120902;

class Solution {
    public int solution(String my_string) {
        // 3 + 7
        String[] calcList = my_string.split(" ");
        int answer = Integer.parseInt(calcList[0]);

        for (int i = 1; i < calcList.length; i += 2) {
            answer = (calcList[i].equals("+")) ?
                    answer + Integer.parseInt(calcList[i + 1]):
                    answer - Integer.parseInt(calcList[i + 1]);
            System.out.println("answer = " + answer);
        }

        return answer;
    }
}
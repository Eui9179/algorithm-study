package org.codingtest.level0.p120864;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] stringArr = my_string.replaceAll("[a-zA-z]", " ").split(" ");
        for (String string : stringArr) {
            if (!string.equals("")) {
                answer += Integer.parseInt(string);
            }
        }
        return answer;
    }
}
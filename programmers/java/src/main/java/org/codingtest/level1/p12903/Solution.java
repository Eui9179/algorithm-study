package org.codingtest.level1.p12903;

class Solution {
    public String solution(String s) {
        int slen = s.length() / 2;
        String answer = s.charAt(slen) + "";
        if (s.length() % 2 == 0) {
            answer = s.charAt(slen - 1) + answer;
        }
        return answer;
    }
}

package org.codingtest.level0.p120904;

public class Solution {
    public int solution(int num, int k) {
        String numStr = String.valueOf(num);
        String kStr = String.valueOf(k);
        int answer = numStr.indexOf(kStr);
        return answer > 0 ? answer + 1: -1;
    }
}

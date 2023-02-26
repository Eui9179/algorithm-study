package org.codingtest.level0.p120887;

import java.util.stream.IntStream;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String kStr = String.valueOf(k);
        String numStr;

        for (int l = i; l <= j; l++) {
            numStr = String.valueOf(l);
            answer += numStr.length() - numStr.replace(kStr, "").length();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(1, 13, 1));
    }
}
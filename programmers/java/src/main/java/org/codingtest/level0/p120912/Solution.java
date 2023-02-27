package org.codingtest.level0.p120912;

import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        return Arrays.stream(array).map(n -> String.valueOf(n).length() - String.valueOf(n).replace("7", "").length()).sum();
//        int answer = 0;
//        for (int n : array) {
//            String nStr = String.valueOf(n);
//            answer += nStr.length() - nStr.replace("7", "").length();
//        }
//        return answer;
    }
}

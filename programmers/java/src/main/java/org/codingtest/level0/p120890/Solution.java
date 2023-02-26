package org.codingtest.level0.p120890;

import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        int compAbs;
        int answer = 0;
        int minAbs = Math.abs(array[0] - n);
        int minNum = array[0];

        for (int i = 1; i < array.length; i++) {
            compAbs = Math.abs(array[i] - n);
            if (compAbs < minAbs) {
                answer = i;
                minAbs = compAbs;
            } else if (compAbs == minAbs) {
                answer = (array[i] < array[answer]) ? i : answer;
            }
        }
        return array[answer];
    }
}
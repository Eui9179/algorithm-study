package org.codingtest.level0.p120923;

import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        for (int i = 0; i < num; i++) {
            answer[i] = i;
        }

        int sum = Arrays.stream(answer).sum();
        int addNum;

        while (sum != total) {
            addNum = (sum < total) ? 1:-1;
            for (int i = 0; i < answer.length; i++) {
                answer[i] += addNum;
            }
            sum = Arrays.stream(answer).sum();
        }
        return answer;
    }
}
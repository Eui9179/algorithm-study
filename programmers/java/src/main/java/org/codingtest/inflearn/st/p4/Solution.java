package org.codingtest.inflearn.st.p4;

import java.util.*;

class Solution {
    public int solution(int[] score, int k){
        int answer = 0;

        Arrays.sort(score);

        for (int i = 0; i < score.length - 2; i++) {
            if (score[i + k - 1] - score[i] > 10) continue; // 10 초과면 끝
            if (answer > 0) return answer; // 10 이하인 것이 여러 개인 상황이기 때문에 바로 끝

            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += score[i + j];
            }
            answer = sum / k;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
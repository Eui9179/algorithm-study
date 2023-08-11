package org.codingtest.inflearn.implement_1;

import java.util.Arrays;

class Solution {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        for (int user = 1; user <= n; user++) {
            int current = user;
            for (int[] step : ladder) {
                current += moveLadder(current, step);
            }
            answer[current - 1] = String.valueOf((char) (64 + user)).charAt(0);
        }

        return answer;
    }

    public int moveLadder(int current, int[] step) {
        for (int s : step) {
            if (current == s) {
                return 1;
            }

            if (current - 1 == s) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
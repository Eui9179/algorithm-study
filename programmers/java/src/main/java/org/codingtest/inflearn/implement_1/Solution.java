package org.codingtest.inflearn.implement_1;

import java.util.Arrays;

class Solution {

    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            answer[i] = String.valueOf((char) (65 + i)).charAt(0);
        }

        for (int[] steps : ladder) {
            for (int step : steps) {
                changePosition(answer, step);
            }
        }

        return answer;
    }

    public void changePosition(char[] node, int position) {
        char tmp = node[position];
        node[position] = node[position - 1];
        node[position - 1] = tmp;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
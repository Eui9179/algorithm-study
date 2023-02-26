package org.codingtest.level0.p120842;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        int col = 0;
        for (int i = 0; i < num_list.length; i += n) {
            for (int j = 0; j < n; j++) { //횟수
                answer[col][j] = num_list[i + j];
            }
            col++;
        }
        return answer;
    }
}
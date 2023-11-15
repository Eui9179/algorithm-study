package org.codingtest.inflearn.implement.p1;
import java.util.*;

class Solution2 {
    public char[] solution(int n, int[][] ladder){
        char[] answer = initAnswer(n);
        for (int[] l: ladder) {
            for (int j : l) {
                swapValue(answer, j - 1, j);
            }
        }

        return answer;
    }

    private char[] initAnswer(int n) {
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = (char) ('A' + i);
        }
        return result;
    }

    private void swapValue(char[] values, int index1, int index2) {
        char tmp = values[index1];
        values[index1] = values[index2];
        values[index2] = tmp;
    }

    public static void main(String[] args){
        Solution2 T = new Solution2();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
package org.codingtest.inflearn.implement_2;

import java.util.*;
class Solution {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];

        int n = board.length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;

        while (k > 0) {
            k--;
            int nextI = answer[0] + directions[direction][0];
            int nextJ = answer[1] + directions[direction][1];

            if (nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= n) {
                direction = (direction + 1) % 4;
                continue;
            }

            if (board[nextI][nextJ] == 1) {
                direction = (direction + 1) % 4;
                continue;
            }

            answer[0] = nextI;
            answer[1] = nextJ;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
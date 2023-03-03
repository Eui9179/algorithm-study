package org.codingtest.level0.p120866;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] step = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};
        int step_i;
        int step_j;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 1) continue;
                for (int[] s : step) {
                    step_i = i + s[0];
                    step_j = j + s[1];
                    if (!check(step_i, step_j, board.length)) continue;
                    if (board[step_i][step_j] != 1) board[step_i][step_j] = 2;
                }
            }
        }

        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(ints[j] + " ");
                if (ints[j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static boolean check(int a, int b, int length) {
        return a >= 0 && a < length && b >= 0 && b < length;
    }
}

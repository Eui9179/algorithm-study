package org.codingtest.level2.p17679;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // m = 4
        // n = 5
        // board
        /*
        c c b d e
        a a a d e
        a a a b f
        c c b b f
         */
        String[][] newBoard = genBoardArr(m, n, board);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isBoom(i, j, newBoard, true)) {
                    answer += dfs(i, j, newBoard);
                    System.out.println("right: " + i + ", " + j);
                }

                if (isBoom(i, j, newBoard, false)) {
                    answer += dfs(i, j, newBoard);
                    System.out.println("left: " + i + ", " + j);
                }
            }
        }
        return answer;
    }

    public int dfs(int a, int b, String[][] board) {
        // TODO dfs 구현
        return 0;
    }

    public String[][] genBoardArr(int m, int n, String[] board) {
        String[][] newBoard = new String[m][n];
        String[] row;

        for (int i = 0; i < m; i++) {
            row = board[i].split("");
            System.arraycopy(row, 0, newBoard[i], 0, n);
        }
        return newBoard;
    }

    public boolean isBoom(int a, int b, String[][] board, boolean right) {
        int m = board.length;
        int n = board[0].length;
        int nextA, nextB;

        int[][] steps;

        if (right) {
            steps = new int[][]{{1, 0}, {1, 1}, {0, 1}};
        } else {
            steps = new int[][]{{1, 0}, {1, -1}, {0, -1}};
        }

        String cur = board[a][b];

        for (int[] step : steps) {
            nextA = step[0] + a;
            nextB = step[1] + b;

            if (nextA < 0 || nextB < 0 || nextA >= m || nextB >= n) return false;
            if (!cur.equals(board[nextA][nextB])) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    }

    public void show(String[][] arr) {
        for (String[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}

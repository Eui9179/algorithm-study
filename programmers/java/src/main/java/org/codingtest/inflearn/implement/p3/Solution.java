package org.codingtest.inflearn.implement.p3;

class Solution {
    public int solution(int[][] board){
        int answer = 0;

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        int md = 0;
        int dd = 0;

        int[] mp = findObject(board, 2);
        int[] dp = findObject(board, 3);

        while (answer < 10_000) {
            if (!move(board, mp, di, dj, md)) {
                md = (md + 1) % 4;
            }

            if (!move(board, dp, di, dj, dd)) {
                dd = (dd + 1) % 4;
            }

            if (mp[0] == dp[0] && mp[1] == dp[1]) {
                return answer + 1;
            }

            answer++;
        }

        return 0;
    }

    public boolean move(int[][] board, int[] position, int[] di, int[] dj, int d) {
        int pi = position[0] + di[d];
        int pj = position[1] + dj[d];

        if (pi < 0 || pj < 0 || pi >= 10 || pj >= 10) {
            return false;
        }

        if (board[pi][pj] == 1) {
            return false;
        }

        position[0] = pi;
        position[1] = pj;

        return true;
    }

    public int[] findObject(int[][] board, int o) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == o) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
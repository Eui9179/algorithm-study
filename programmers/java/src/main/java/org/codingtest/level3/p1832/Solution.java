package org.codingtest.level3.p1832;

import java.util.Arrays;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        // 0: 자동차 자유
        // 1: 통행 금지
        // 2: 직진만 가능 (회전 금지)

        // 통행 가능한 전체 경로 수

        // 1. 기본 경로: [i][j] = [i - 1][j] + [i][j - 1]
        // 2. 금지: [i][j] = [i - 1][j] ? [i][j - 1] or 
        // 3. 직진만 가능: [i][j] = [i - 1][j] ? [i - 2][j] + [i][j - 1] or else
        // 나 기준으로 측정 -> 내가 금지 or 직진이라면 넘어감

        int[][] history = new int[m][n];

        for (int i = 1; i < m; i++) {
            if (cityMap[i][0] == 1) continue;
            history[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (cityMap[0][i] == 1) continue;
            history[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // 지금 위치 기준으로 생각
                // 내가 금지라면? 0으로 하고 넘어감
                // 내가 좌, 우회전 금지라면? 벽에 있으면 한 방향밖에 안됨
                 if (cityMap[i][j] == 1) {
                     continue;
                 }

                 if (cityMap[i][j] == 2) {
                     if (i == m - 1) {
                         if (j - 1 > 0) {
                            history[i][j] = history[i][j - 1];
                         }
                         continue;
                     } else if (j == n - 1) {
                         if (i - 1 > 0) {
                            history[i][j] = history[i - 1][j];
                         }
                         continue;
                     }
                 }


                 if (cityMap[i - 1][j] == 1) {
                     history[i][j] = (history[i][j - 1]) % MOD;
                 }

                 else if (cityMap[i][j - 1] == 1) {
                     history[i][j] = (history[i - 1][j]) % MOD;
                 }

                 else if (cityMap[i - 1][j] == 2) {
                     if (i - 2 < 0) {
                         history[i][j] = (history[i][j - 1]) % MOD;
                     } else {
                         history[i][j] = (history[i - 2][j] + history[i][j - 1]) % MOD;
                     }
                 }

                 else if (cityMap[i][j - 1] == 2) {
                     if (j - 2 < 0) {
                         history[i][j] = (history[i - 1][j]) % MOD;
                     } else {
                         history[i][j] = (history[i - 1][j] + history[i][j - 2]) % MOD;
                     }
                 }

                 else {
                     history[i][j] = (history[i - 1][j] + history[i][j - 1]) % MOD;
                 }
            }
        }

        for (int i = 0; i < m; i ++) {
            System.out.println(Arrays.toString(history[i]));
        }

        return (history[m - 1][n - 1]) % MOD;
    }
}
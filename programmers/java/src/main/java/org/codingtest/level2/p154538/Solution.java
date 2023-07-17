package org.codingtest.level2.p154538;

import java.util.Arrays;

public class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[x] = 0;
        if (x + n <= y) dp[x + n] = 1;
        if (x * 2 <= y) dp[x * 2] = 1;
        if (x * 3 <= y) dp[x * 3] = 1;

        for (int i = x + 1; i < y + 1; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }

            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }

            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}

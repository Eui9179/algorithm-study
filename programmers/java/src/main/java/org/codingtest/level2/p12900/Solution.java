package org.codingtest.level2.p12900;

class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < n + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }

        return dp[n];
    }
}

package org.codingtest.level2.p12945;

class Solution {
    public int fibo(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }

    public int solution(int n) {
        return fibo(n);
    }
}
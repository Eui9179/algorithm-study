package org.codingtest.level0.p120840;

import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        BigInteger[] dp = new BigInteger[balls + 1];
        dp[0] = BigInteger.valueOf(1);

        for (int i = 1; i <= balls; i++) {
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
        }

        return dp[balls].divide((dp[balls - share]).multiply(dp[share])).intValue();
    }

    public static void main(String[] args) {
        new Solution().solution(30, 29);
    }
}
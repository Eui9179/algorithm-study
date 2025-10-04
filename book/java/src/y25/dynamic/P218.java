package y25.dynamic;

import java.util.Arrays;

public class P218 {

    public static void main(String[] args) {
        int num = 26;

        // Top down
        int[] dp = new int[num + 1];
        solution(num, dp, 0);
        System.out.println(dp[1]);

        // Bottom up
        System.out.println(solutionWithBottomUp(num));
    }

    private static void solution(int num, int[] dp, int count) {
        // num이 0 되면 종료
        if (num <= 0) return;

        // 이미 계산된 값이고 count 보다 작은 값이면 계산 종료
        if (dp[num] != 0 && dp[num] < count) return;

        // 계산된 적 없거나 count 보다 크면 업데이트
        if (dp[num] == 0 || dp[num] > count) dp[num] = count;

        if (num % 5 == 0) solution(num / 5, dp, count + 1);
        if (num % 3 == 0) solution(num / 3, dp, count + 1);
        if (num % 2 == 0) solution(num / 2, dp, count + 1);
        solution(num - 1, dp, count + 1);
    }

    private static int solutionWithBottomUp(int num) {
        int[] dp = new int[num + 1];

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= num; i++) {
            dp[i] = dp[i - 1] + 1;
            if (dp[i / 5] != 0) dp[i] = Math.min(dp[i / 5] + 1, dp[i]);
            if (dp[i / 3] != 0) dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            if (dp[i / 2] != 0) dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
        }

        return dp[num];
    }
}

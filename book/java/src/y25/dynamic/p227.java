package y25.dynamic;

import java.util.Arrays;

public class p227 {
    public static void main(String[] args) {
        System.out.println(solution(15, new int[]{2, 3}));
        System.out.println(solution(4, new int[]{3, 5, 7}));
    }

    private static int solution(int m, int[] kinds) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1);

        for (int k : kinds) {
            if (k <= m) dp[k] = 1;
        }

        for (int i = 1; i <= m; i++) {
            int min = Integer.MAX_VALUE;
            for (int k : kinds) {
                if (i - k < 0 || dp[i - k] == -1) continue;
                min = Math.min(min, dp[i - k]);
            }
            if (min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }

        return dp[m];
    }
}

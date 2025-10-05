package y25.dynamic;

public class p224 {
    public static void main(String[] args) {

    }

    /**
     * 1 - 2*1
     * 2 - (2*1, 2*1), (1*2, 1*2), (2*2)
     * 3 - (2*1, 2*1, 2*1),
     *     (2*1, 1*2, 1*2),
     *     (1*2, 1*2, 2*1),
     *     (2*1, 2*2),
     *     (2*2, 2*1)
     *  지금까지 구해온 경우의 수에서
     *  (i - 1에서 (2*1) 하나 넣는 방법 + i - 2에서 (2*2), (1*2, 1*2))
     *  넣는 경우의 수밖에 없음
     */
    private static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + (dp[i - 2] * 2);
        }

        return dp[n];
    }
}

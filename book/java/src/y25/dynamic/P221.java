package y25.dynamic;

public class P221 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 1, 5}));
    }

    private static int solution(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        dp[1] = array[1];

        for (int i = 2; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
        }

        return dp[dp.length - 1];
    }

}

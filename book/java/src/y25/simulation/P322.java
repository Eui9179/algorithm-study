package y25.simulation;

public class P322 {

    public static void main(String[] args) {
        System.out.println(solution(123402));
        System.out.println(solution(7755));
    }

    private static String solution(int score) {
        String scoreStr = String.valueOf(score);

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < scoreStr.length() / 2; i++) {
            leftSum += Integer.parseInt(String.valueOf(scoreStr.charAt(i)));
            rightSum += Integer.parseInt(String.valueOf(scoreStr.charAt(i + scoreStr.length() / 2)));
        }

        return leftSum == rightSum ? "LUCKY" : "READY";
    }
}

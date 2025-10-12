package y25.greedy;

public class P313 {
    public static void main(String[] args) {
        System.out.println(solution("02984"));
        System.out.println(solution("2984"));
        System.out.println(solution("567"));
    }

    private static int solution(String nums) {
        int answer = 0;

        int[] numArray = new int[nums.length()];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.parseInt(String.valueOf(nums.charAt(i)));
        }

        for (int num : numArray) {
            if (answer <= 1 || num <= 1) {
                answer += num;
            } else {
                answer *= num;
            }
        }

        return answer;
    }

}

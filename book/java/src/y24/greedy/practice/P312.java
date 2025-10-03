package y24.greedy.practice;

public class P312 {
    public static int solution(String numStr) {
        int answer = 0;

        for (int i = 0; i < numStr.length(); i++) {
            int num = numStr.charAt(i) - '0';
            answer = Math.max(answer + num, answer * num);
        }
        return answer;
    }
}

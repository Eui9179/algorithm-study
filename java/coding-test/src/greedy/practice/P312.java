package greedy.practice;

import java.util.Scanner;

/**
 * String to char
 * toCharArray()
 * charAt
 *
 * char to String
 * String.valueOf()
 */
public class P312 {
    public static int solution(String numStr) {
        int answer = 0;

        for (int i = 0; i < numStr.length(); i++) {
            int num = numStr.charAt(i) - '0';
            answer = Math.max(answer + num, answer * num);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        System.out.println(solution(numStr));
    }
}

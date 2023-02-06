package implementations.practice;

import java.util.Arrays;
import java.util.Scanner;

public class P322 {
    public static String solution(String str) {
        int sum = 0;
        char[] sortedChars = str.toCharArray();
        Arrays.sort(sortedChars);

        StringBuilder sb = new StringBuilder();

        for (char c: sortedChars) {
            if (c - '0' < 10) {
                sum += c - '0';
            } else {
                sb.append(c);
            }
        }
        sb.append(sum);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("answer = " + solution(str));
    }
}

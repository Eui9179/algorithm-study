package greedy.practice;

import java.util.Scanner;

public class P313 {
    public static int solution(String s) {
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                if (s.charAt(i) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
        }
        return Math.min(count0, count1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }
}

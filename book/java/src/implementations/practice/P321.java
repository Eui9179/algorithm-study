package implementations.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P321 {
    public static void solution(int n) {
        String numStr = String.valueOf(n);
        int mid = numStr.length()/2;
        int left = 0, right = 0;

        for (int i = 0; i < mid; i++) {
            left += numStr.charAt(i) - '0';
            right += numStr.charAt(i + mid) - '0';
        }

        if (left == right) {
            System.out.println("lucky");
        } else {
            System.out.println("ready");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}

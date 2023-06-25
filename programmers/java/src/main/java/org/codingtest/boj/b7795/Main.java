package org.codingtest.boj.b7795;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[m];

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                A[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                B[j] = sc.nextInt();
            }
            Arrays.sort(B);
            System.out.println(pro(A, B));
        }
    }

    public static int pro(int[] A, int[] B) {
        int answer = 0;
        for (int a : A) {
            answer += lowerBound(a, B);
        }

        return answer;
    }

    public static int lowerBound(int num, int[] B) {
        if (B[0] > num) {
            return 0;
        }

        if (B[B.length - 1] < num) {
            return B.length;
        }

        int left = 0;
        int right = B.length - 1;

        int result = 0;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (num > B[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}

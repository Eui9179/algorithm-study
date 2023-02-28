package org.codingtest.level0.p120878;

import java.util.ArrayList;

class Solution {
    public int solution(int a, int b) {
        if (a % b == 0) return 1;
        int gcd = 0;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        if (gcd != 0) b /= gcd;

        for (int i = 2; i <= b/2; i++) {
            if (b % i == 0 && i % 2 != 0 && i % 5 != 0) {
                return 2;
            }
        }
        if (b % 2 != 0 && b % 5 != 0) {
            return 2;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(12, 21));
    }
}

package org.codingtest.level0.p120808;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        numer1 *= denom2;
        numer2 *= denom1;

        int denom = denom1 * denom2;
        int numer = numer1 + numer2;
        int gcd = 1;

        for (int i = 1; i <= Math.max(denom, numer); i++) {
            if (denom % i == 0 && numer % i == 0) {
                gcd = i;
            }
        }

        return new int[]{denom / gcd, numer / gcd};
    }
}

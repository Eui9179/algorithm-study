package org.codingtest.level1.p12940;

class Solution {
    public int[] solution(int n, int m) {
        return new int[]{calcGCD(n, m), calcLCM(n, m)};
    }

    public int calcGCD(int n, int m) {
        int result = 1;
        for (int i = 2; i < Math.max(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                result = i;
            }
        }
        return result;
    }

    public int calcLCM(int n, int m) {
        return (n * m) / calcGCD(n, m);
    }
}

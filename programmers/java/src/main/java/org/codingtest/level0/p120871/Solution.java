package org.codingtest.level0.p120871;

class Solution {
    public int solution(int n) {
        int x3 = 1;
        int i = 0;
        while (i < n) {
            if (x3 % 3 == 0) {
                x3++;
                continue;
            }
            if (String.valueOf(x3).contains("3")) {
                x3++;
                continue;
            }
            x3++;
            i++;

        }
        return x3;
    }

    public static void main(String[] args) {
        new Solution().solution(40);
    }
}
package org.codingtest.level0.p120875;

class Solution {
    public int solution(int[][] dots) {
        int in1, in2;

        int[][] step = {{0, 1, 2, 3}, {0, 2, 1, 3}, {0, 3, 1, 2}};

        for (int[] s : step) {
            in1 = (dots[s[0]][1] - dots[s[1]][1]) / (dots[s[0]][0] - dots[s[1]][0]);
            in2 = (dots[s[2]][1] - dots[s[3]][1]) / (dots[s[2]][0] - dots[s[3]][0]);
            if (in2 != 0 && in1 / in2 == 1) {
                return 1;
            }
        }
        return 0;
    }
}

package org.codingtest.level0.p120860;

public class Solution {
    public int solution(int[][] dots) {
        int xIndex = 0, yIndex = 0;

        for (int i = 1; i < dots.length; i++) {
            if (dots[0][1] == dots[i][1]) {
                xIndex = i;
            } else if (dots[0][0] == dots[i][0]) {
                yIndex = i;
            }
        }
        return Math.abs(dots[0][0] - dots[xIndex][0]) * Math.abs(dots[0][1] - dots[yIndex][1]);
    }
}

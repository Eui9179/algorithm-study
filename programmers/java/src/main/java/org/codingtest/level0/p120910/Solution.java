package org.codingtest.level0.p120910;

public class Solution {
    public int solution(int n, int t) {
        for (int i = 0; i < t; i++) {
            n *= 2;
        }
        return (int)(n * Math.pow(2, t));
    }
}

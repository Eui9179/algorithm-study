package org.codingtest.level0.p120837;

public class Solution {
    public int solution(int n) {
        int nSqrt = (int)Math.sqrt(n);
        return (nSqrt * nSqrt == n) ? 1 : 2;
    }
}

package org.codingtest.level0.p120816;
public class Solution {
    public static int solution(int slice, int n) {
        // 7조각이라면?
        return n / 7 + ((n % slice != 0) ? 1: 0);
    }
    public static void main(String[] args) {

    }
}

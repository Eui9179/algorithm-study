package org.codingtest.level0.p120848;

class Solution {
    public int solution(int n) {
        int preValue = 1;
        int i = 2;

        while (true) {
            preValue *= preValue * i;
            if (preValue > n) {
                return i - 1;
            }
            i++;
        }
    }
}
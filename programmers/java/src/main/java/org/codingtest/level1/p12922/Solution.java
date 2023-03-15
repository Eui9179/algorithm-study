package org.codingtest.level1.p12922;

class Solution {
    public String solution(int n) {
        return n % 2 == 0 ? "수박".repeat(n / 2) : "수박".repeat(n / 2) + "수";
    }
}
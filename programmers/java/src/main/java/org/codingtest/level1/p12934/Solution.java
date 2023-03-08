package org.codingtest.level1.p12934;

class Solution {
    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);
        return Math.pow(sqrt, 2) == n ? (long) Math.pow(sqrt + 1, 2) : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(121));
    }
}

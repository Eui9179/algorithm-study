package org.codingtest.level1.p12947;

class Solution {
    public boolean solution(int x) {
        int sum = String.valueOf(x).chars().map(i -> i - '0').sum();
        return x % sum == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(18));
    }
}

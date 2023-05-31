package org.codingtest.level2.p92335;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(101011, 10));
    }

    public int solution(int n, int k) {
        int answer = 0;
        String nk = Integer.toString(n, k);
        String[] noZero = nk.split("0");

        for (String numStr : noZero) {
            if (!numStr.equals("") && isPrime(Long.parseLong(numStr)))
                answer++;
        }
        return answer;
    }

    public boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2) return true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

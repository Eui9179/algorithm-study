package org.codingtest.basic_test;

// 1~23으로 다 나눠지는 가장 작은 수
public class P29 {
    public static void main(String[] args) {
        int n = 23;
        System.out.println(solution(n));
    }
    public static long solution(int n) {
        long gcd;
        long[] table = new long[n + 1];
        table[2] = 2;
        table[3] = 6;

        for (int i = 4; i < n + 1; i++) {
            // i - 1로 다 나눠지는 값이 i 로도 나눠지면 그대로
            if (table[i - 1] % i == 0) {
                table[i] = table[i - 1];
                continue;
            }

            gcd = getGCD(i, table[i - 1]);

            // 최대공약수가 없다면 table[i - 1]과 현재 값을 곱한 값
            // 최대공약수가 있다면 table[i - 1]을 최대공약수로 나누고 현재 값과 곱한 값
            table[i] = gcd == 0 ?
                    table[i - 1] * i :
                    (table[i - 1] / gcd) * i;
        }
        return table[n];
    }
    public static long getGCD(long a, long b) {
        long result = 0;
        for (long i = 2; i < Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return result;
    }
}

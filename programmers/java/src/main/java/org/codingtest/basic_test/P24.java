package org.codingtest.basic_test;

import java.math.BigInteger;

public class P24 {
    public static void main(String[] args) {
        System.out.println(solution(50000000));
    }
    public static BigInteger solution(int num) {
        long[] fiboTable = new long[num + 1];
        BigInteger answer = BigInteger.ZERO;

        fiboTable[1] = 1;
        fiboTable[2] = 2;

        for (int i = 3; i <= num; i++) {
            fiboTable[i] = fiboTable[i - 1] + fiboTable[i - 2];
        }

        for (long l : fiboTable) {
            answer = answer.add(BigInteger.valueOf(l));
        }
        return answer;
    }
}

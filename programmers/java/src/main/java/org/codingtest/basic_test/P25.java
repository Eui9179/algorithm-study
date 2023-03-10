package org.codingtest.basic_test;

import java.math.BigInteger;
import java.util.ArrayList;

// 1600851475143의 수 중 제일 큰 약수
public class P25 {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static long solution() {
        // 약수 중에 소수인 애
        BigInteger bigNum = new BigInteger("1600851475143");
        ArrayList<BigInteger> numList = new ArrayList<>();
        // 1 약수
        for (BigInteger i = BigInteger.TWO;
             i.compareTo(bigNum.sqrt()) < 0;
             i = i.add(BigInteger.ONE)) {

            // 1. 약수이면서 짝수가 아닌 애들
            if (bigNum.mod(i).equals(BigInteger.ZERO) &&
                    !i.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
                // 2. 소수 고르기
                int count = 0;
                for (BigInteger j = BigInteger.ONE;
                     j.compareTo(i.sqrt()) < 0;
                     j = j.add(BigInteger.ONE)) {
                    if (i.mod(j).equals(BigInteger.ZERO)) {
                        count++;
                    }
                    if (count > 1) break;
                }
                if (count == 1) numList.add(i);
            }
        }
        return numList.get(numList.size() - 2).longValue();
    }
}

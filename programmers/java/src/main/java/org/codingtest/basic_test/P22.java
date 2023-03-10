package org.codingtest.basic_test;

import java.util.stream.LongStream;

public class P22 {
    public static void main(String[] args) {
        System.out.println(solution(100000));
    }
    public static long solution(long num) {
        return LongStream.range(1, num)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();
    }
}
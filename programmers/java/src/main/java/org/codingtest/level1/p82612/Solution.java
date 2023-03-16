package org.codingtest.level1.p82612;

import java.util.stream.LongStream;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = LongStream.rangeClosed(1, count)
                .map(i -> price * i)
                .sum();
        return answer > money ? answer - money : 0;
    }
}
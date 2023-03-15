package org.codingtest.level1.p77884;

import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (isOdd(i)) {
                answer -= i;
            } else {
                answer += i;
            }
        }
        return answer;
    }

    public boolean isOdd(int num) {
        int count = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count % 2 == 0;
    }

}
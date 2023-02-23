package org.codingtest.level0.p120905;

import java.util.Arrays;

public class Solution {
    public int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist)
                .filter(i -> i % n == 0)
                .toArray();
    }
}

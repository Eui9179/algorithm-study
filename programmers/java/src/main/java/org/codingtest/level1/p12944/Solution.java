package org.codingtest.level1.p12944;

import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }
}

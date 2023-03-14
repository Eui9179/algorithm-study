package org.codingtest.level1.p86051;

import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 3, 4});
    }
}

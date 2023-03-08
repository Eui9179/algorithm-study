package org.codingtest.level1.p12933;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String[] nStrArr = String.valueOf(n).split("");
        Arrays.sort(nStrArr, Collections.reverseOrder());
        System.out.println(Arrays.toString(nStrArr));
        return Long.parseLong(String.join("", nStrArr));
    }

    public static void main(String[] args) {
        new Solution().solution(118372L);
    }
}

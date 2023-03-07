package org.codingtest.level1.p12931;

import java.util.*;

public class Solution {
    public int solution(int n) {
        return String.valueOf(n).chars().map(c -> c - '0').sum();
    }

    public static void main(String[] args) {
        new Solution().solution(123);
    }
}

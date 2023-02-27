package org.codingtest.level0.p120853;

import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string
                .replace("- ", "-")
                .replace("+ ", "")
                .trim()
                .split(" ")
        ).mapToInt(Integer::parseInt).sum();
    }

    public static void main(String[] args) {
        new Solution().solution("3 + 4");
    }
}
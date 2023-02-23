package org.codingtest.level0.p120851;

import java.util.Arrays;

public class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char[] chars = my_string.toCharArray();
        for (char c : chars) {
            if (c < 'A') {
                answer += c - '0';
            }
        }
        return answer;
    }
}

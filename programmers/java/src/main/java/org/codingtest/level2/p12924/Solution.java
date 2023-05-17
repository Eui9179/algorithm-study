package org.codingtest.level2.p12924;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(15));
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i < n; i++) {
            int sum = i;
            for (int j = i + 1; j < n; j++) {
                sum += j;
                if (sum > n) {
                    break;
                } else if (sum == n) {
                    answer += 1;
                    break;
                }
            }
        }

        return answer + 1;
    }
}
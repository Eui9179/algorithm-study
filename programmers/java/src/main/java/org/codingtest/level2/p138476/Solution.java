package org.codingtest.level2.p138476;

import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        int[] tangerines = new int[10000001];
        for (int t : tangerine) {
            tangerines[t] += 1;
        }

        Arrays.sort(tangerines);
        for (int i = tangerines.length - 1; i >= 0; i--) {
            k -= tangerines[i];
            answer++;
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}

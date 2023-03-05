package org.codingtest.p120876;

import java.util.Arrays;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int count;
        int start = Arrays.stream(lines).mapToInt(l -> l[0]).min().getAsInt();
        int end = Arrays.stream(lines).mapToInt(l -> l[1]).max().getAsInt();

        for (int i = start; i <= end; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                if (i > lines[j][0] && i <= lines[j][1]) {
                    count++;
                }
            }
            if (count > 1) {
                answer++;
            }
        }
        return answer;
    }
}

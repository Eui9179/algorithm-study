package org.codingtest.level0.p120846;

class Solution {
    public int solution(int n) {
        int answer = 0;
        if (n == 1) return 0;
        else if (n == 2) return 0;
        else if (n == 3) return 0;

        int[] d = new int[n + 1];
        d[1] = 1;
        d[2] = 2;
        d[3] = 2;

        for (int i = 4; i <= n; i++) {
            if (i % 2 == 0) answer++;
            else {
                int count = 0;
                for (int j = 1; j < i / 2; j++) {
                    if (i % j == 0) {
                        if (d[j] > 1) {
                            count = 3;
                            answer++;
                            break;
                        }
                        count++;
                    }
                }
                d[i] = count + 1;
            }
        }
        return answer;
    }
}
package y25.level1;

import java.util.Arrays;

public class P135808 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int fCount = 0;
        int min = Integer.MAX_VALUE;

        Arrays.sort(score);

        for (int i = score.length - 1; i >= 0; i--) {
            if (fCount == m) {
                answer += (min * m);
                fCount = 1;
                min = score[i];
            } else {
                min = Math.min(min, score[i]);
                fCount++;
            }
        }

        if (fCount == m) {
            answer += (min * m);
        }

        return answer;
    }
}

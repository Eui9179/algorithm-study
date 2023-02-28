package org.codingtest.level0.p120882;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int[] solution(int[][] score) {
        ArrayList<Integer> scores = new ArrayList<>();
        for (int[] s : score) {
            scores.add(s[0] + s[1]);
        }
        scores.sort(Collections.reverseOrder());

        int[] answer = new int[scores.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = scores.indexOf(score[i][0] + score[i][1]) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[][]{{1, 3}, {3, 1}, {2, 3}, {3, 2}, {1, 2}, {0, 0}});
    }

}

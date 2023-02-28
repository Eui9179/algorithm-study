package org.codingtest.level0.p120861;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        int limitX = (board[0] / 2);
        int limitY = (board[1] / 2);

        Map<String, ArrayList<Integer>> step = new HashMap<>();
        step.put("left", new ArrayList<>(Arrays.asList(-1, 0)));
        step.put("right", new ArrayList<>(Arrays.asList(1, 0)));
        step.put("up", new ArrayList<>(Arrays.asList(0, 1)));
        step.put("down", new ArrayList<>(Arrays.asList(0, -1)));

        for (String key : keyinput) {
            int nextX = answer[0] + step.get(key).get(0);
            int nextY = answer[1] + step.get(key).get(1);
            if (Math.abs(nextX) <= limitX && Math.abs(nextY) <= limitY) {
                answer[0] = nextX;
                answer[1] = nextY;
            }
        }
        return answer;
    }
}

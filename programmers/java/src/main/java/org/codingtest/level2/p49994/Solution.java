package org.codingtest.level2.p49994;

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        List<int[]> record = new ArrayList<>();

        Map<Character, int[]> commandMap = new HashMap<>();
        commandMap.put('U', new int[]{0, 1});
        commandMap.put('D', new int[]{0, -1});
        commandMap.put('R', new int[]{1, 0});
        commandMap.put('L', new int[]{-1, 0});

        int[] start = new int[]{0, 0};
        record.add(new int[]{start[0], start[1]});
        int max = 5;
        int min = -5;

        char command;
        int nextX, nextY;

        for (int i = 0; i < dirs.length(); i++) {
            if (start[0] < min || start[0] > max || start[1] < min || start[1] > max)
                continue;

            command = dirs.charAt(i);

            if (isExist(record, start)) {
                start[0] += commandMap.get(command)[0];
                start[1] += commandMap.get(command)[1];
                continue;
            }

            record.add(new int[]{start[0], start[1]});
            start[0] += commandMap.get(command)[0];
            start[1] += commandMap.get(command)[1];
            answer++;
        }

        return answer;
    }

    public boolean isExist(List<int[]> record, int[] point) {
        for (int i = 0; i < record.size() - 1; i++) {
            if (record.get(i)[0] == point[0] && record.get(i)[1] == point[1]) {
                return true;
            }
        }
        return false;
    }
}
package org.codingtest.level2.p49994;

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] position = new int[]{0, 0};
        Set<String> record = new HashSet<>();
        Map<Character, int[]> commandMap = getCommandMap();

        for (int i = 0; i < dirs.length(); i++) {
            char command = dirs.charAt(i);
            int nextX = position[0] + commandMap.get(command)[0];
            int nextY = position[1] + commandMap.get(command)[1];

            if (nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5) {
                continue;
            }

            if (isExist(record, position[0], position[1], nextX, nextY)) {
                position[0] = nextX;
                position[1] = nextY;
                continue;
            }

            record.add(generateKey(position[0], position[1], nextX, nextY));
            position[0] = nextX;
            position[1] = nextY;
            answer++;
        }

        return answer;
    }

    public Map<Character, int[]> getCommandMap() {
        return Map.of(
                'U', new int[]{0, 1},
                'D', new int[]{0, -1},
                'R', new int[]{1, 0},
                'L', new int[]{-1, 0}
        );
    }

    public boolean isExist(Set<String> record, int x, int y, int nextX, int nextY) {
        String key1 = generateKey(x, y, nextX, nextY);
        String key2 = generateKey(nextX, nextY, x, y);

        return record.contains(key1) || record.contains(key2);
    }

    public String generateKey(int a, int b, int c, int d) {
        return new StringBuilder()
                .append(a).append("-")
                .append(b).append("-")
                .append(c).append("-")
                .append(d).toString();
    }
}
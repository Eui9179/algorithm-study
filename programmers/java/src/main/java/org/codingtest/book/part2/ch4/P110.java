package org.codingtest.book.part2.ch4;

import java.util.Map;

public class P110 {
    public static void main(String[] args) {
        System.out.println(solution(5, new String[]{"R", "R", "R", "U", "D", "D"}));
    }

    public static String solution(int n, String[] commands) {
        int x = 0, y = 0;

        Map<String, int[]> commandMap = Map.of(
                "R", new int[]{0, 1},
                "L", new int[]{0, -1},
                "U", new int[]{-1, 0},
                "D", new int[]{1, 0});

        for (String command : commands) {
            int nextX = x + commandMap.get(command)[0];
            int nextY = y + commandMap.get(command)[1];

            if (nextX >= n || nextY >= n || nextX < 0 || nextY < 0) {
                continue;
            }

            x = nextX;
            y = nextY;
        }

        return (x + 1)+ " " + (y + 1);
    }

}

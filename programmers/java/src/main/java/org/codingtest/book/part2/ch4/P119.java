package org.codingtest.book.part2.ch4;

import java.util.Map;

public class P119 {
    private static final Map<Integer, int[]> backSideMap = Map.of(
            0, new int[]{1, 0},
            1, new int[]{0, 1},
            2, new int[]{-1, 0},
            3, new int[]{0, -1}
    );

    private static final Map<Integer, int[]> leftSideMap = Map.of(
            0, new int[]{0, -1},
            1, new int[]{1, 0},
            2, new int[]{0, 1},
            3, new int[]{-1, 0}
    );

    public static void main(String[] args) {
        System.out.println(solution(4, 4, new int[]{1, 1}, 0, new int[][]{{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}}));

    }

    public static int solution(int n, int m, int[] position, int direction, int[][] map) {
        while (true) {
            int nextA = position[0] + leftSideMap.get(direction)[0];
            int nextB = position[1] + leftSideMap.get(direction)[1];

            if ((nextA < 0 || nextA >= n || nextB < 0 || nextB >= m) || map[nextA][nextB] == -1) {
                continue;
            }

            position[0] = nextA;
            position[1] = nextB;

            map[position[0]][position[1]] = -1;

            if (endCondition(map, position, direction)) break;
        }

        int answer = 0;
        for (int[] row : map) {
            for (int data : row) {
                if (data == -1) answer++;
            }
        }

        return answer;

    }

    private static boolean endCondition(int[][] map, int[] position, int direction) {
        int backPositionA = position[0] + backSideMap.get(direction)[0];
        int backPositionB = position[1] + backSideMap.get(direction)[1];

        return (backPositionA < 0 || backPositionB < 0 || backPositionA >= map.length || backPositionB >= map.length) ||
                map[backPositionA][backPositionB] != 1;
    }
}

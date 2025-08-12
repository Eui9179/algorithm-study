package org.codingtest.book.part2.ch5;

import java.util.*;

public class P152 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        }));
        System.out.println(solution(new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 1}
        }));

    }

    private static int solution(int[][] map) {
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<int[]> queue = new ArrayList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.remove(0);
            for (int[] move : moves) {
                int nextA = node[0] + move[0];
                int nextB = node[1] + move[1];

                if (nextA < 0 || nextA >= map.length || nextB < 0 || nextB >= map[0].length) continue;

                if (map[nextA][nextB] == 1) {
                    map[nextA][nextB] = map[node[0]][node[1]] + 1;
                    queue.add(new int[]{nextA, nextB});
                }
            }
        }

        return map[map.length - 1][map[0].length - 1];
    }
}

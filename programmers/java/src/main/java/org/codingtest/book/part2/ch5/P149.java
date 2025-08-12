package org.codingtest.book.part2.ch5;

import java.util.*;

public class P149 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        }));
        System.out.println(solution(new int[][]{
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        }));
    }

    private static int solution(int[][] graph) {
        int answer = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0) {
                    dfs(graph, i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    private static void dfs(int[][] graph, int i, int j) {
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<int[]> stack = new ArrayList<>();
        stack.add(new int[]{i, j});
        graph[i][j] = -1;

        while (!stack.isEmpty()) {
            int[] node = stack.remove(stack.size() - 1);
            for (int[] move : moves) {
                int nextX = node[0] + move[0];
                int nextY = node[1] + move[1];

                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) continue;
                if (graph[nextX][nextY] == 0) {
                    stack.add(new int[]{nextX, nextY});
                    graph[nextX][nextY] = -1;
                }
            }
        }
    }
}

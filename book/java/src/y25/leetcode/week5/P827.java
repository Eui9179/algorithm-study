package y25.leetcode.week5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P827 {

    private int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int largestIsland(int[][] grid) {
        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    int[][] copy = Arrays.stream(grid)
                            .map(int[]::clone)
                            .toArray(int[][]::new);
                    answer = Math.max(bfs(copy, new int[]{i, j}), answer);
                }
            }
        }
        return answer == 0 ? grid.length * grid[0].length : answer;
    }

    private int bfs(int[][] copy, int[] start) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (copy[current[0]][current[1]] == -1) {
                continue;
            }

            copy[current[0]][current[1]] = -1;
            count++;

            for (int[] direction : directions) {
                int nextX = current[0] + direction[0];
                int nextY = current[1] + direction[1];

                if (nextX < 0 || nextY < 0 || nextX >= copy.length || nextY >= copy[0].length) {
                    continue;
                }

                if (copy[nextX][nextY] == -1 || copy[nextX][nextY] == 0) continue;

                queue.offer(new int[]{nextX, nextY});
            }
        }
        return count;
    }
}

package y25.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P150 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        }));
    }

    private static int solution(int[][] map) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    dfs(map, i, j);
                    count++;
                }
            }
        }

        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
        return count;
    }

    private static void dfs(int[][] map, int x, int y) {
        List<int[]> stack = new ArrayList<>();
        stack.add(new int[]{x, y});
        map[x][y] = 2;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!stack.isEmpty()) {
            int[] current = stack.remove(stack.size() - 1);
            for (int[] direction : directions) {
                int nextX = current[0] + direction[0];
                int nextY = current[1] + direction[1];

                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) {
                    continue;
                }

                if (map[nextX][nextY] == 0) {
                    map[nextX][nextY] = 2;
                    stack.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}

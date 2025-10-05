package y25.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P153 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
        }));
    }

    private static int solution(int[][] map) {
        bfs(map);

        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
        return map[map.length - 1][map[0].length - 1];
    }

    private static void bfs(int[][] map) {
        List<int[]> queue = new ArrayList<>();
        queue.add(new int[]{0, 0});

        map[0][0] = 1;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.remove(0);
            for (int[] direction : directions) {
                int a = current[0] + direction[0];
                int b = current[1] + direction[1];

                if (a < 0 || a >= map.length || b < 0 || b >= map[0].length) continue;
                if (map[a][b] == 1) {
                    map[a][b] = map[current[0]][current[1]] + 1;
                    queue.add(new int[]{a, b});
                }
            }
        }
    }
}

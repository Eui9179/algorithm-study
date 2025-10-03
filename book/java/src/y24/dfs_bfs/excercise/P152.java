package y24.dfs_bfs.excercise;

import java.util.ArrayDeque;
import java.util.Deque;

public class P152 {
    private static int[][] movements = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    private static int[][] map = {
            {1, 1, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1},
            {1, 1, 0, 0, 1, 0},
            {1, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 1}
    };

    public static void main(String[] args) {
        int result = solution(new int[]{0, 0}, 5, 6);
        System.out.println("result = " + result);
    }

    private static int solution(int[] start, int n, int m) {
        int answer = 0;

        Deque<int[]> queue = new ArrayDeque();
        queue.addLast(start);

        map[start[0]][start[1]] = 0;

        int[] lastNode = start;

        while (!queue.isEmpty()) {
            int[] path = queue.pop();

            if (path[0] == n-1 && path[1] == m-1) {
                return ++answer;
            }

            for (int[] move : movements) {
                int next_i = path[0] + move[0];
                int next_j = path[1] + move[1];
                if (next_i < 0 || next_i >= n || next_j < 0 || next_j >= m) {
                    continue;
                }
                if (map[next_i][next_j] == 1) {
                    queue.addLast(new int[]{next_i, next_j});
                    map[next_i][next_j] = 0;
                }
            }
            if (!queue.contains(lastNode)) {
                lastNode = queue.getLast();
                answer += 1;
            }
        }
        return 0;
    }
}

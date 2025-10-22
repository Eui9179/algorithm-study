package y25.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P343 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {2, 0, 0, 0, 1, 1, 0},
                {0, 0, 1, 0, 1, 2, 0},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0}
        }));
    }

    private static int solution(int[][] map) {
        int answer = 0;
        // 세울 수 있는 벽
        List<int[]> availableWall = new ArrayList<>();
        // 바이러스 위치
        List<int[]> virus = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    availableWall.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        List<List<int[]>> walls = new ArrayList<>();
        combine(walls, 3, availableWall, new ArrayList<>(), 0);

        for (List<int[]> wall : walls) {
            for (int[] w : wall) {
                map[w[0]][w[1]] = 1;
            }

            int[][] copy = new int[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                copy[i] = Arrays.copyOf(map[i], map.length);
            }

            spreedVirus(copy, virus);

            int count = 0;
            for (int[] cp : copy) {
                for (int c : cp) {
                    if (c == 0) count++;
                }
            }

            answer = Math.max(answer, count);

            for (int[] w : wall) {
                map[w[0]][w[1]] = 0;
            }
        }

        return answer;
    }

    private static void spreedVirus(int[][] map, List<int[]> virus) {
        List<int[]> queue = new ArrayList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] v : virus) {
            queue.add(v);
            while (!queue.isEmpty()) {
                int[] current = queue.remove(0);

                for (int[] direction : directions) {
                    int nextI = current[0] + direction[0];
                    int nextJ = current[1] + direction[1];

                    if (nextI < 0 || nextI >= map.length || nextJ < 0 || nextJ >= map[0].length) {
                        continue;
                    }

                    if (map[nextI][nextJ] == 0) {
                        map[nextI][nextJ] = 2;
                        queue.add(new int[]{nextI, nextJ});
                    }
                }

            }
        }
    }

    private static void combine(
            List<List<int[]>> result,
            int pickSize,
            List<int[]> nums,
            List<int[]> tmp,
            int index
    ) {
        if (pickSize == tmp.size()) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            tmp.add(nums.get(i));
            combine(result, pickSize, nums, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

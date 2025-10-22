package y25.simulation;

import java.util.*;

public class P328 {
    private final static int APPLE = 6;

    public static void main(String[] args) {
        System.out.println(solution(6,
                new int[][]{{3, 4}, {2, 5}, {5, 3}},
                new int[][]{{3, 1}, {15, -1}, {17, 1}}));
        System.out.println(solution(10,
                new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}},
                new int[][]{{8, 1}, {10, 1}, {11, 1}, {13, -1}}));

    }

    private static int solution(int n, int[][] apples, int[][] moves) {
        int[][] map = new int[n][n];
        for (int[] apple : apples) {
            map[apple[0] - 1][apple[1] - 1] = APPLE;
        }

        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }

        int playTime = 0;
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[]{0, 0});

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;

        Map<Integer, Integer> moveTimeMap = new HashMap<>();
        for (int[] move : moves) {
            moveTimeMap.put(move[0], move[1]);
        }

        while (true) {
            playTime++;

            int[] head = snake.get(snake.size() - 1);

            int[] nextHead = {head[0] + directions[direction][0], head[1] + directions[direction][1]};

            // 벽에 닿으면 게임 종료
            if (nextHead[0] >= map.length || nextHead[1] >= map[0].length ||
                    nextHead[0] < 0 || nextHead[1] < 0) {
                return playTime;
            }

            // 몸에 닿으면 게임 종료
            for (int i = 0; i < snake.size() - 1; i++) {
                int[] body = snake.get(i);
                if (nextHead[0] == body[0] && nextHead[1] == body[1]) {
                    return playTime;
                }
            }

            // 사과 먹음
            if (map[nextHead[0]][nextHead[1]] == APPLE) {
                snake.add(new int[]{nextHead[0], nextHead[1]});
                map[nextHead[0]][nextHead[1]] = 0;
            } else { // 사과 아니면 꼬리 지움
                snake.add(new int[]{nextHead[0], nextHead[1]});
                snake.remove(0);
            }

            if (moveTimeMap.containsKey(playTime)) {
                if (moveTimeMap.get(playTime) == 1) {
                    if (++direction == directions.length) direction = 0;
                } else {
                    if (--direction < 0) direction = directions.length - 1;
                }
                System.out.println("Chage direction : " + Arrays.toString(directions[direction]));
            }

            System.out.println("playTime = " + playTime);
            for (int[] s : snake) {
                System.out.print(Arrays.toString(s));
            }
            System.out.println();
            System.out.println();
        }
    }
}

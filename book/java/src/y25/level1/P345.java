package y25.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P345 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1, 0, 2},
                {0, 0, 0},
                {3, 0, 0},
        }, 2, 3, 2));

        System.out.println(solution(new int[][]{
                {1, 0, 2},
                {0, 0, 0},
                {3, 0, 0}
        }, 1, 2, 2));

    }

    private static int solution(int[][] map, int s, int x, int y) {

        // 우선순위 큐
        Queue<Virus> pq = new PriorityQueue<>();
        // 대기 큐
        List<Virus> standby = new ArrayList<>();

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] != 0) {
                    standby.add(new Virus(map[i][j], i, j));
                }
            }
        }

        for (int i = 1; i <= s; i++) {
            pq.addAll(standby);
            standby.clear();
            while (!pq.isEmpty()) {
                Virus virus = pq.poll();

                for (int[] direction : directions) {
                    int nextX = virus.x + direction[0];
                    int nextY = virus.y + direction[1];

                    if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) {
                        continue;
                    }

                    if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = virus.kind;
                        standby.add(new Virus(virus.kind, nextX, nextY));
                    }
                }
            }
        }

        return map[x - 1][y - 1];
    }

    private static class Virus implements Comparable<Virus> {
        int kind;
        int x;
        int y;

        Virus(int kind, int x, int y) {
            this.kind = kind;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Virus virus) {
            return this.kind - virus.kind;
        }
    }

}

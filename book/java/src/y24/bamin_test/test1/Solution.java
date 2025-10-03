package y24.bamin_test.test1;

import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {
    public int solution(int width, int height, int[][] diagonals) {
        BigInteger answer = BigInteger.ZERO;
        width++;
        height++;
        ArrayList<int[]> q;
        BigInteger[][] map;
        boolean[][] visited;

        int[][] directions = new int[][]{{1, 0}, {0, 1}};

        int ni, nj;

        for (int[] diagonal : diagonals) {
            map = new BigInteger[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    map[i][j] = BigInteger.ZERO;
                }
            }


            visited = new boolean[height][width];
            q = new ArrayList<>();
            int x = diagonal[0] - 1;
            int y = diagonal[1];


            q.add(new int[]{0, 0});

            while (q.size() > 0) {
                int[] node = q.remove(0);
                if (visited[node[0]][node[1]]) {
                    continue;
                }
                visited[node[0]][node[1]] = true;

                for (int[] direction : directions) {
                    ni = node[0] + direction[0];
                    nj = node[1] + direction[1];

                    if (ni >= height || nj >= width) {
                        continue;
                    }

                    if (ni < x && nj > y) {
                        continue;
                    }

                    if (map[node[0]][node[1]].equals(BigInteger.ZERO)) {
                        map[ni][nj] = map[ni][nj].add(BigInteger.ONE);
                    } else {
                        map[ni][nj] = map[ni][nj].add(map[node[0]][node[1]]);
                    }
                    q.add(new int[]{ni, nj});
                }
            }
            answer = answer.add(map[height - 1][width - 1]);
        }
        return answer.mod(BigInteger.valueOf(10000019)).intValue();
    }
}

package y25.leetcode.week2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxiamlSquare_221 {
    public static void main(String[] args) {
        System.out.println(new MaxiamlSquare_221().maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));

        System.out.println(new MaxiamlSquare_221().maximalSquare(new char[][]{
                {'0', '1'},
                {'0', '1'}
        }));


    }

    private final int[][] directions = new int[][]{{0, 1}, {1, 0}};

    public int maximalSquare(char[][] matrix) {
        int answer = 0;

        for (int max = matrix.length; max > 0 ; max--) {
            boolean updated = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (dfs(matrix, max, i, j)) {
                        answer = max;
                        updated = true;
                        break;
                    }
                }
                if (updated) break;
            }
        }

        return answer == 1 ? 1 : (int) Math.pow(answer, 2);
    }

    private boolean dfs(char[][] matrix, int max, int i, int j) {
        if (matrix[i][j] == '0') {
            return false;
        }
        int count = 0;
        char[][] copy = new char[matrix.length][];
        for (int row = 0; row < matrix.length; row++) {
            copy[row] = new char[matrix[row].length];
            System.arraycopy(matrix[row], 0, copy[row], 0, matrix[row].length);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (copy[current[0]][current[1]] == '0') {
                return false;
            }

            if (copy[current[0]][current[1]] == '2') {
                continue;
            }

            copy[current[0]][current[1]] = '2';
            count++;

            for (int[] direction : directions) {
                int nextI = current[0] + direction[0];
                int nextJ = current[1] + direction[1];

                if ((nextI >= copy.length || nextJ >= copy[0].length)) {
                    continue;
                }

                if (nextI < i + max && nextJ < j + max)
                    queue.offer(new int[]{nextI, nextJ});
            }
        }

        return count == (int) Math.pow(max, 2);
    }
}

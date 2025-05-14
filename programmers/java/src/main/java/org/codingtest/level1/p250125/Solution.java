package org.codingtest.level1.p250125;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[][]{{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}}, 1, 1));
    }

    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] direction : directions) {
            if (h + direction[0] >= board.length || h + direction[0] < 0 ||
                    w + direction[1] >= board[0].length || w + direction[1] < 0) continue;

            String color = board[h][w];
            if (color.equals(board[h + direction[0]][w + direction[1]])) {
                answer++;
            }

        }
        return answer;
    }
}

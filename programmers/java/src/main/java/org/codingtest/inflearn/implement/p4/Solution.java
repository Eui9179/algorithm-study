package org.codingtest.inflearn.implement.p4;

import java.util.*;
class Solution {
    public int[] solution(int c, int r, int k){
        if (c * r < k) return new int[]{0, 0};
        return run(c, r, k);
    }

    public int[] run(int c, int r, int k) {
        boolean[][] visited = new boolean[c][r];
        int[] position = {0, 0};

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int direction = 0;

        visited[position[0]][position[1]] = true;

        int i = 1;
        while (i < k) {
            int npx = position[0] + dx[direction];
            int npy = position[1] + dy[direction];

            if (npx < 0 || npy < 0 || npx >= c || npy >= r || visited[npx][npy]) {
                direction = (direction + 1) % 4;
                continue;

            }

            position[0] = npx;
            position[1] = npy;
            visited[position[0]][position[1]] = true;
            i++;
        }

        position[0]++;
        position[1]++;

        return position;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
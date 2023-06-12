package org.codingtest.level2.p1844;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }

    public int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // n-1, m-1 도착
        List<List<Integer>> q = new ArrayList<>();

        q.add(new ArrayList<>(Arrays.asList(0, 0)));

        while (q.size() > 0) {

            for (int[] map : maps) {
                for (int ma : map) {
                    System.out.print(ma + " ");
                }
                System.out.println();
            }
            List<Integer> node = q.remove(0);

            if (node.get(0) == n - 1 && node.get(1) == m - 1) {
                return maps[node.get(0)][node.get(1)];
            }

            for (int[] direction : directions) {
                int nextA = node.get(0) + direction[0];
                int nextB = node.get(1) + direction[1];

                if (nextA < 0 || nextA >= n || nextB < 0 || nextB >= m) {
                    continue;
                }

                if (maps[nextA][nextB] == 0 || maps[nextA][nextB] > 1) {
                    continue;
                }

                maps[nextA][nextB] = maps[node.get(0)][node.get(1)] + 1;

                q.add(new ArrayList<>(Arrays.asList(nextA, nextB)));
            }
            System.out.println();
        }

        return -1;
    }

    public int solution(int[][] maps) {
        return bfs(maps);
    }
}
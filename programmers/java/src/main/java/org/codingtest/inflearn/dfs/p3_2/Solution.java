package org.codingtest.inflearn.dfs.p3_2;

import java.util.*;

class Solution {
    public int solution(int[][] cans) {
        List<Integer> visited = new ArrayList<>();
        return pickK2(cans, cans.length / 2, visited, Integer.MAX_VALUE);
    }

    private void combinationK(List<List<Integer>> cases, int k, List<Integer> visited) {
        if (visited.size() == k) {
            cases.add(new ArrayList<>(visited));
            return;
        }

        for (int i = 0; i < k * 2; i++) {
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            combinationK(cases, k, visited);
            visited.remove(visited.size() - 1);
        }
    }


    private int pickK2(int[][] cans, int k, List<Integer> visited, int result) {
        if (visited.size() == k) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < cans.length; i++) {
                if (visited.contains(i)) sum1 += cans[i][0];
                else sum2 += cans[i][1];
            }
            return Math.abs((sum1 - sum2));
        }

        for (int i = 0; i < k * 2; i++) {
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            result = Math.min(result, pickK2(cans, k, visited, result));
            visited.remove(visited.size() - 1);
        }
        return result;
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
    }
}

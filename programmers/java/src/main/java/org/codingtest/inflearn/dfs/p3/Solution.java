package org.codingtest.inflearn.dfs.p3;

import java.util.*;

class Solution {
    public int solution(int[][] cans) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> cases = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        pickK(cases, cans.length / 2, visited);

        for (List<Integer> whites : cases) {
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < cans.length; i++) {
                if (whites.contains(i)) {
                    sum1 += cans[i][0];
                } else {
                    sum2 += cans[i][1];
                }
                answer = Math.min(Math.abs(sum1 - sum2), answer);
            }
        }

        return answer;
    }

    private void pickK(List<List<Integer>> cases, int k, List<Integer> visited) {
        if (visited.size() == k) {
            cases.add(new ArrayList<>(visited));
            return;
        }

        for (int i = 0; i < k * 2; i++) {
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            pickK(cases, k, visited);
            visited.remove(visited.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
    }
}

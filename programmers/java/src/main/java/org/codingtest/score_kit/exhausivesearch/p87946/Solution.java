package org.codingtest.score_kit.exhausivesearch.p87946;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
80 	[[80,20],[50,40],[30,10]] 	3
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }

    public int solution(int k, int[][] dungeons) {
        int[] answer = new int[]{0, 0, 0};
        boolean[] visited = new boolean[dungeons.length];
        Set<int[]> set = new HashSet<>();
        rec(set, answer, new int[]{0, 1, 2}, visited, 0);
        return answer[2];
    }

    private void rec(Set<int[]> set, int[] output, int[] indexes, boolean[] visited, int depth) {
        if (depth == output.length) {
            set.add(output);
            System.out.println(Arrays.toString(output));
            return;
        }

        for (int i = 0; i < indexes.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            output[depth] = indexes[i];
            rec(set, output, indexes, visited, depth + 1);
            visited[i] = false;
        }
    }
}
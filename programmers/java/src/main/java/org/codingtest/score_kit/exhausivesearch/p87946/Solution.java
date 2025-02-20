package org.codingtest.score_kit.exhausivesearch.p87946;

import java.util.*;

/*
80 	[[80,20],[50,40],[30,10]] 	3
 */
class Solution {

    private static int answer = 0;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }

    private void dfs(int r, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= r) {
                visited[i] = true;
                dfs(r - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }

    public int solution2(int k, int[][] dungeons) {
        int answer = 0;
        List<int[]> sequence = generateSequence(dungeons.length);
        for (int[] seq : sequence) {
            int remain = k;
            int count = 0;
            for (int s : seq) {
                if (remain >= dungeons[s][0]) {
                    remain -= dungeons[s][1];
                    count++;
                } else break;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }



    private List<int[]> generateSequence(int length) {
        List<int[]> result = new ArrayList<>();
        int[] output = new int[length];
        int[] indexes = initIndexes(length);
        boolean[] visited = new boolean[length];
        perm(result, output, indexes, visited, 0);
        return result;
    }

    private void perm(List<int[]> result, int[] output, int[] indexes, boolean[] visited, int depth) {
        if (depth == output.length) {
            result.add(Arrays.copyOf(output, output.length));
            return;
        }

        for (int i = 0; i < indexes.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            output[depth] = indexes[i];
            perm(result, output, indexes, visited, depth + 1);
            visited[i] = false;
        }
    }

    private int[] initIndexes(int length) {
        int[] indexes = new int[length];
        for (int i = 0; i < length; i++) indexes[i] = i;
        return indexes;
    }
}
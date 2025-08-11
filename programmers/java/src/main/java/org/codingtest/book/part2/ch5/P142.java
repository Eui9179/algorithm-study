package org.codingtest.book.part2.ch5;

public class P142 {
    public static void main(String[] args) {
        dfs(new int[][]{{}, {2, 3, 8}, {1, 7}, {1, 4, 5}, {3, 5}, {3, 4}, {7}, {2, 6, 8}, {1, 7}}, 1, new boolean[]{false, false, false, false, false, false, false, false, false});

    }

    public static void dfs(int[][] graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v);

        for (int i = 0; i < graph[v].length; i++) {
            if (!visited[graph[v][i]]) {
                dfs(graph, graph[v][i], visited);
            }
        }
    }
}

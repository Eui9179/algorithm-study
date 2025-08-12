package org.codingtest.book.part2.ch5;

import java.util.*;

public class P147 {
    private final static int[][] graph = {
            {},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}
    };

    public static void main(String[] args) {
        boolean[] visited = new boolean[9];
        bfs(1, visited);
    }

    public static void bfs(int v, boolean[] visited) {
        List<Integer> queue = new ArrayList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int node = queue.remove(0);

            System.out.println(node);

            for (int next: graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}

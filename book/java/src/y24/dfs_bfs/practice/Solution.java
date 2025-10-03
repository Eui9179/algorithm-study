package y24.dfs_bfs.practice;

import java.util.*;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public int solution(int n, int[][] computers) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        ArrayList<Integer> groups = new ArrayList<>();

        initData(n, computers, graph, groups);

        for (int node : graph.keySet()) {
            if (groups.get(node) > -1) continue; // 이미 노드의 그룹이 정해졌다면 넘어간다.
            dfsFunc(graph, groups, node);
        }

        return new HashSet<>(groups).size(); // 그룹을 set 자료구조로 중복 제거
    }

    public static void dfsFunc(Map<Integer, ArrayList<Integer>> graph, ArrayList<Integer> groups, int startNode) {
        /**
         * 1. stack에 초기 데이터를 넣는다.
         * 2. stack이 빌 때까지 노드를 꺼내서 현재 노드의 그룹을 시작노드로 설정한다.
         * 3. 현재 노드와 연결된 노드를 stack에 넣는다.
         */
        ArrayList<Integer> stack = new ArrayList<>(Arrays.asList(startNode));

        while (stack.size() > 0) {
            Integer node = stack.remove(0);

            if (groups.get(node) > -1) {
                continue;
            }

            groups.set(node, startNode);

            stack.addAll(0, graph.get(node));
        }
    }

    public static void initData(int n, int[][] computers, Map<Integer, ArrayList<Integer>> graph, ArrayList<Integer> groups) {
        /**
         * 인접 리스트로 데이터 초기화
         * 노드가 포함된 그룹 -1로 초기화
         */

        //graph와 groups 초기화
        IntStream.range(0, n)
                .forEach(i -> {
                    graph.put(i, new ArrayList<>());
                    groups.add(-1);
                });

        // 인접 행렬 -> 인접 리스트
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) graph.get(i).add(j);
            }
        }
    }
}
package org.codingtest.score_kit.bfsdfs.p443162;
/*
문제 설명
네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.

컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

제한사항
컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
computer[i][i]는 항상 1입니다.
입출력 예
n	computers	return
3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 */

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0},{1, 1, 1},{0, 1, 1}}));
    }

    public int solution(int n, int[][] computers) {

        Map<Integer, List<Integer>> nodes = initNodes(computers);
        List<Integer> queue = new ArrayList<>();
        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < n; i++) group.add(-1);

        for (int startNode = 0; startNode < n; startNode++) {
            queue.add(startNode);
            while (!queue.isEmpty()) {
                int node = queue.remove(0);
                if (group.get(node) != -1) continue;
                group.set(node, startNode);
                queue.addAll(nodes.get(node));
            }
        }

        return new HashSet<>(group).size();
    }

    private Map<Integer, List<Integer>> initNodes(int[][] computers) {
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        for (int i = 0; i < computers.length; i++) {
            nodes.put(i, new ArrayList<>());
            for (int j = 0; j < computers[i].length; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    nodes.get(i).add(j);
                }
            }
        }
        return nodes;
    }
}

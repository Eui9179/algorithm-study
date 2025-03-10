package org.codingtest.score_kit.exhausivesearch.p86971;

import java.util.*;

/*
입출력 예
n 	wires 	result
9 	{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}} 	3
4 	{{1,2},{2,3},{3,4}} 	0
7 	{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}} 	1
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(new Solution().solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(new Solution().solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int disconnect = 0; disconnect < n; disconnect++) {
            Map<Integer, List<Integer>> nodes = initNodes(n, wires, disconnect);
            List<Integer> queue = new ArrayList<>();
            int[] groups = new int[n + 1];
            Arrays.fill(groups, -1);
            for (int startNode = 1; startNode <= n; startNode++) {
                queue.add(startNode);
                while (!queue.isEmpty()) {
                    Integer node = queue.remove(0);
                    if (groups[node] != -1) continue;
                    groups[node] = startNode;
                    queue.addAll(nodes.get(node));
                }
            }
            answer = Math.min(answer, diffGroupCount(groups));
        }

        return answer;
    }

    private Map<Integer, List<Integer>> initNodes(int n, int[][] wires, int disconnect) {
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        for (int i = 1; i <= n; i++) nodes.put(i, new ArrayList<>());
        for (int i = 0; i < wires.length; i++) {
            if (i == disconnect) continue;
            nodes.get(wires[i][0]).add(wires[i][1]);
            nodes.get(wires[i][1]).add(wires[i][0]);
        }
        return nodes;
    }

    private int diffGroupCount(int[] groups) {
        int count1 = 0, count2 = 0;
        for (int i = 1; i < groups.length; i++) {
            int standard = groups[1];
            if (standard == groups[i]) count1++;
            else count2++;
        }
        return Math.abs(count1 - count2);
    }
}

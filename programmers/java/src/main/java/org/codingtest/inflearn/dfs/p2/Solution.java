package org.codingtest.inflearn.dfs.p2;

import java.util.*;

class Solution {
    private static int answer;

    public int solution(int[][] fight){
        answer = 0;
        Map<Integer, List<Integer>> map = generateMap(7);
        exceptFight(map, fight);

        for (int i = 1; i <= 7; i++) {
            List<Integer> visited = new ArrayList<>();
            visited.add(i);
            dfs(i, map, visited);
        }

        return answer;
    }

    public void dfs(Integer node, Map<Integer, List<Integer>> map, List<Integer> visited) {
        if (visited.size() == 7) {
            answer++;
            return;
        }

        for (Integer nextNode : map.get(node)) { // for 문을 통해서 특정 노드가 방문했던 노드는 다시 방문하지 않음
            if (visited.contains(nextNode)) continue;
            visited.add(node); // 방문 노드 삽입
            dfs(nextNode, map, visited); // dfs
            visited.remove(visited.size() - 1); // 방문했던 노드 지우기
        }
    }

    public Map<Integer, List<Integer>> generateMap(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    map.get(i).add(j);
                }
            }
        }
        return map;
    }

    public void exceptFight(Map<Integer, List<Integer>> map, int[][] fight) {
        for (int[] f : fight) {
            int s1 = f[0];
            int s2 = f[1];

            map.get(s1).remove(Integer.valueOf(s2));
            map.get(s2).remove(Integer.valueOf(s1));
        }
    }



    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}

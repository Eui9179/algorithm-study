package org.codingtest.score_kit.bfsdfs.p43164;

import java.util.*;

/*
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
//        Map<String, List<Node>> path = generatePath(tickets);
        Map<String, List<String>> path = generatePath(tickets);
        System.out.println(path);



//        List<Node> queue = new ArrayList<>();
        return answer;
    }

    private void dfs() {

    }



//    private Map<String, List<Node>> generatePath(String[][] tickets) {
    private Map<String, List<String>> generatePath(String[][] tickets) {
//        Map<String, List<Node>> path = new HashMap<>();
        Map<String, List<String>> path = new HashMap<>();

        for (String[] ticket : tickets)
            path.put(ticket[0], new ArrayList<>());

        for (String[] ticket : tickets)
            path.get(ticket[0]).add(ticket[1]);

        return path;
    }

    private static class Node {
        private final String value;
        private int depth = 0;

        private Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", depth=" + depth +
                    '}';
        }
    }
}

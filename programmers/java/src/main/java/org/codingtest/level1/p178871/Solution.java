package org.codingtest.level1.p178871;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(
                new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"}))
        );
    }

    public String[] solution(String[] players, String[] callings) {
        String[] answer = Arrays.copyOf(players, players.length);

        Map<String, Integer> ranking = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }

        for (String calling : callings) {
            int rank = ranking.get(calling);
            String pre = answer[rank - 1];

            ranking.put(calling, rank - 1);
            ranking.put(pre, rank);

            answer[rank - 1] = calling;
            answer[rank] = pre;
        }

        return answer;
    }
}

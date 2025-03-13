package org.codingtest.score_kit.exhausivesearch.p43163;

import java.util.*;

/**
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    public int solution(String begin, String target, String[] words) {
        Map<String, Integer> countMap = initCountMap(begin, target, words);
        List<String> queue = new ArrayList<>();
        queue.add(begin);

        while (!queue.isEmpty()) {
            String current = queue.remove(0);

            for (String word : words) {
                if (diffOneChar(current, word) && countMap.get(word) == 0) {
                    queue.add(word);
                    countMap.put(word, countMap.get(current) + 1);
                }
            }
        }

        return countMap.get(target);
    }

    private Map<String, Integer> initCountMap(String begin, String target, String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put(begin, 0);
        countMap.put(target, 0);
        for (String word : words) countMap.put(word, 0);
        return countMap;
    }

    private boolean diffOneChar(String current, String word) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != word.charAt(i)) count++;
        }
        return count == 1;
    }
}

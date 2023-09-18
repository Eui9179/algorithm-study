package org.codingtest.inflearn.hashing.p2;

import java.util.*;

class Solution {
    Map<String, Integer> alphaMap = Map.of(
            "a", 0,
            "b", 1,
            "c", 2,
            "d", 3,
            "e", 4
    );

    public int[] solution(String s) {
        List<Integer> counts = generateCounts(s);
        int max = Collections.max(counts);

        return generateAnswer(counts, max);
    }

    private List<Integer> generateCounts(String s) {
        List<Integer> counts = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (String str : s.split("")) {
            int alphaIndex = alphaMap.get(str);
            counts.set(alphaIndex, counts.get(alphaIndex) + 1);
        }
        return counts;
    }

    private int[] generateAnswer(List<Integer> counts, int max) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = max - counts.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }

}

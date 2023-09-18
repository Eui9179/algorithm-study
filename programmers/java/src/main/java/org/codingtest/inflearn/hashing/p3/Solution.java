package org.codingtest.inflearn.hashing.p3;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        List<Integer> countValues = generateCounts(s);
        Set<Integer> countSet = new HashSet<>();

        countSet.add(countValues.get(0));

        for (int i = 1; i < countValues.size(); i++) {
            int count = countValues.get(i);
            while (countSet.contains(count) && count > 0) {
                count--;
                answer++;
            }
            countSet.add(count);
        }

        return answer;
    }

    private List<Integer> generateCounts(String s) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : s.split("")) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }
        return new ArrayList<>(countMap.values());
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}

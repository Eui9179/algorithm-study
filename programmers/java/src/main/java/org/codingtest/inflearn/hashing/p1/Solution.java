package org.codingtest.inflearn.hashing.p1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s){
        return findMinimumWordIndex(s);
    }

    private int findMinimumWordIndex(String s) {
        String[] split = s.split("");
        Map<String, Integer> map = generateCountMap(split);

        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            if (map.get(str) == 1) {
                return i + 1;
            }
        }
        return -1;
    }

    private Map<String, Integer> generateCountMap(String[] s) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : s) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
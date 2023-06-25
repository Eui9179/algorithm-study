package org.codingtest.c.test2;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("NAANAAXNABABYNNBZ"));
        System.out.println(new Solution().solution("QWERQWERQWERAAABNN"));
        System.out.println(new Solution().solution("AAABBNN"));
        System.out.println(new Solution().solution("AB"));
        System.out.println(new Solution().solution("BBN"));
        System.out.println(new Solution().solution("BB"));
        System.out.println(new Solution().solution(""));
    }
    public int solution(String S) {
        Map<String, Integer> bananaMap = getBananaMap(S);

        if (bananaMap.keySet().size() < 3) {
            return 0;
        }

        int aCount = bananaMap.get("A") / 3;
        int bCount = bananaMap.get("B");
        int nCount = bananaMap.get("N") / 2;

         return Math.min(aCount, Math.min(bCount, nCount));
    }

    public Map<String, Integer> getBananaMap(String S) {
        String[] sArr = S.split("");
        Map<String, Integer> result = new HashMap<>();
        for (String s : sArr) {
            if (s.equals("B") || s.equals("A") || s.equals("N")) {
                if (result.containsKey(s)) {
                    result.put(s, result.get(s) + 1);
                } else {
                    result.put(s, 1);
                }
            }
        }
        return result;
    }
}


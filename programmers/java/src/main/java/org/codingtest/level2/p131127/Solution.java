package org.codingtest.level2.p131127;

import java.util.*;

class Solution {

    public final int day = 10;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(
                new String[] {"banana", "apple", "rice", "pork", "pot"},
                new int[] {3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0, left = 0, right = 0;
        String curKey;
        Map<String, Integer> wanted = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wanted.put(want[i], number[i]);
        }

        while (right < day) {
            curKey = discount[right];
            if (wanted.containsKey(curKey)) {
                wanted.put(curKey, wanted.get(curKey) - 1);
            }
            right++;
        }

        for (;left < discount.length; left++) {
            if (!isRemain(wanted.values()) ) {
                answer++;
            }
            if (wanted.containsKey(discount[left])) {
                wanted.put(discount[left], wanted.get(discount[left]) + 1);
            }
            if (right < discount.length && wanted.containsKey(discount[right])) {
                wanted.put(discount[right], wanted.get(discount[right]) - 1);
            }
            right++;
        }

        return answer;
    }

    public boolean isRemain(Collection<Integer> list) {
        return list.stream().anyMatch(e -> e > 0);
    }
}

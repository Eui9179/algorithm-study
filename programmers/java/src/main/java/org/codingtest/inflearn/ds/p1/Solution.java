package org.codingtest.inflearn.ds.p1;

import java.sql.Array;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = generateSet(nums); // 중복 제거

        for (int num : set) {
            if (set.contains(num - 1)) continue; // 수열의 시작이 아니라면 무시

            int tmp = 1;
            while (set.contains(++num)) tmp++; // 수열 검사

            answer = Math.max(answer, tmp);
        }

        return answer;
    }

    private Set<Integer> generateSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
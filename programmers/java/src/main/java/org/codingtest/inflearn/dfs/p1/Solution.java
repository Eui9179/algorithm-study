package org.codingtest.inflearn.dfs.p1;

import java.util.*;

class Solution {
    public int solution(int n){
        int[] numberArray = splitSortedNumberArray(n);
        return dfs(numberArray, 0, "", n);
    }

    public int[] splitSortedNumberArray(int n) {
        int length = String.valueOf(n).length();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = n % 10;
            n /= 10;
        }
        Arrays.sort(result);
        return result;
    }

    public int dfs(int[] nums, int level, String currentNumString, int oriNumber) {
        if (level == String.valueOf(oriNumber).length()) {
            return Integer.parseInt(currentNumString);
        }

        for (int num : nums) {
            if (currentNumString.contains(String.valueOf(num))) continue;
            int result = dfs(nums, ++level, currentNumString + num, oriNumber);
            if (result > oriNumber) {
                return result;
            }
            level--;

        }

        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}


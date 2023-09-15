package org.codingtest.inflearn.dfs.p1;

import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> numberArray = splitNumberArray(n);
        List<Integer> visited = splitNumberArray(n);
        Collections.sort(numberArray);
        return dfs(numberArray, "", n, visited);
    }

    public List<Integer> splitNumberArray(int n) {
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            result.add(n % 10);
            n /= 10;
        }
        return result;
    }

    public int dfs(List<Integer> nums, String currentNumString, int oriNumber, List<Integer> visited) {
        if (visited.isEmpty()) {
            return Integer.parseInt(currentNumString);
        }

        for (int num : nums) {
            if (!visited.contains(num)) continue;
            visited.remove(Integer.valueOf(num));
            int result = dfs(nums, currentNumString + num, oriNumber, visited);
            if (result > oriNumber) {
                return result;
            }
            visited.add(num);
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}


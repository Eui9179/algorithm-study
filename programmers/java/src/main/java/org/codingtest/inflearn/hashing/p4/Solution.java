package org.codingtest.inflearn.hashing.p4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 전부 만들어 놓는 것이 아닌, 하나씩 진행하면서 달라지는 map.get(sum) 값을 더해야한다.

class Solution {
    public int solution(int[] nums, int m){
        int answer = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();
        List<Integer> sumList = generateSumList(nums);

        sumMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            if (sumMap.containsKey(sumList.get(i) - m)) {
                answer += sumMap.get(sumList.get(i) - m);
            } else if (sumList.get(i) == m) {
                answer++;
            }
            sumMap.put(sumList.get(i), sumMap.getOrDefault(sumList.get(i), 0) + 1);
        }

        return answer;
    }

    private List<Integer> generateSumList(int[] nums) {
        List<Integer> sumList = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            sumList.add(sum);
        }
        return sumList;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
package org.codingtest.inflearn.st.p3;

import java.util.*;

class Solution {
    public int solution(int[] nums, int k) {
        int answer = 0;

        // 영희 먼저
        // k번 만큼은 영수가 먼저 가져갈 수 있음
        // 영수의 최대값

        Arrays.sort(nums);

        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);

        for (int i = nums.length - 2; i >= 0; i -= 2) {
            answer += nums[i];
            queue.add(Math.abs(nums[i + 1] - nums[i]));
        }

        int add = 0;
        while (!queue.isEmpty() && add < k) {
            answer += queue.poll();
            add++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}
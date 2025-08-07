package org.codingtest.book.part2.ch3;

import java.util.*;

public class P92 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 4, 6}, 8, 3));
        System.out.println(solution(new int[]{3, 4, 3, 4, 3}, 7, 2));
    }

    public static int solution(int[] nums, int m, int k) {
        int answer = 0;
        Arrays.sort(nums);

        int count = 0;

        for (int i = 0; i < m; i++) {
            if (count < k) {
                answer += nums[nums.length - 1];
                count++;
            } else {
                count = 0;
                answer += nums[nums.length - 2];
            }
        }

        return answer;
    }
}

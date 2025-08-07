package org.codingtest.book.part2.ch3;

import java.util.*;

public class P92 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 4, 6}, 8, 3));
        System.out.println(solution(new int[]{3, 4, 3, 4, 3}, 7, 2));
    }

    public static int solution(int[] nums, int m, int k) {
        Arrays.sort(nums);

        int first = nums[nums.length - 1];
        int second = nums[nums.length - 2];

        int count = (k * (m / (k + 1))) + (m % (k + 1));

        return (count * first) + (second * (m - count)); // 중간에 들어가는 개수
    }
}

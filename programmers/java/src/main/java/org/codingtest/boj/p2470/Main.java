package org.codingtest.boj.p2470;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(pro(nums)));
    }

    private static int[] pro(int[] nums) {
        Arrays.sort(nums);

        int pre = Integer.MAX_VALUE;

        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int resultIndex = binarySearch(-x, i + 1, nums.length - 1, nums);

            if (resultIndex < nums.length - 1) {
                if (Math.abs(x + nums[resultIndex]) > Math.abs(x + nums[resultIndex + 1])) {
                    resultIndex++;
                }
            }

            if (Math.abs(x + nums[resultIndex]) < pre) {
                answer[0] = x;
                answer[1] = nums[resultIndex];
                pre = x + nums[resultIndex];
            }
        }
        Arrays.sort(answer);
        return answer;
    }

    private static int binarySearch(int x,int left, int right, int[] nums) {
        int result = 0;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (x > nums[mid]) {
                result = mid;
                left = mid + 1;
            } else if (x < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return result;
    }
}

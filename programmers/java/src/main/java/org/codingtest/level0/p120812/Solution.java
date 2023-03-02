package org.codingtest.level0.p120812;

class Solution {
    public int solution(int[] array) {
        int[] nums = new int[1001];

        for (int i : array) {
            nums[i]++;
        }

        int max = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                count++;
                if (count > 1) {
                    return -1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 3, 3, 3, 4});
    }
}
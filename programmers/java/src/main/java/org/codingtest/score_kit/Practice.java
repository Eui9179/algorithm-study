package org.codingtest.score_kit;

import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        boolean[] visited = new boolean[nums.length];

        for (int i = 1; i < 4; i++) {
            int[] output = new int[i];
            perm(nums, output, visited, 0, i);
        }
    }

    public static void perm(int[] nums, int[] output, boolean[] visited, int index, int r) {
        if (index == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            output[index] = nums[i];
            perm(nums, output, visited, index + 1, r);
            visited[i] = false;
        }
    }
}

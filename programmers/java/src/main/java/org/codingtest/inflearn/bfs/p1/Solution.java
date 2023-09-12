package org.codingtest.inflearn.bfs.p1;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // i번째 타일에 적힌 수를 Ai
        // i번째 타일 위에서 오른쪽으로 Ai이하만큼 점프
        // 최소 점프
        // bfs로
        return bfs(nums);
    }

    public int bfs(int[] nums) {
        int[] history = new int[nums.length];
        Arrays.fill(history, -1);
        history[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            if (history[i] == -1) break;
            for (int j = 1; j <= nums[i]; j++) {
                int jumpPosition = i + j;
                if (jumpPosition >= nums.length) {
                    break;
                }

                if ((history[i] + 1 < history[jumpPosition]) || history[jumpPosition] == -1) {
                    history[jumpPosition] = history[i] + 1;
                }
            }
        }

        return history[history.length - 1];
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
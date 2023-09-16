package org.codingtest.inflearn.implement.p8;

import java.util.*;

class Solution {
    public int[] solution(int[] enter, int[] exit) {
        int n = enter.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            updateCount(answer, enter, exit, i);
        }

        return answer;
    }

    private void updateCount(int[] answer, int[] enter, int[] exit, int enterIndex) {
        // 나 이후로 들어온 사람 && 나보다 먼저 나간 사람 -> 확정
        // 나 ~ 나보다 먼저 나간 사람들 이전에 들어온 사람
        Set<Integer> metSet = new HashSet<>();
        Set<Integer> preExitSet = new HashSet<>();
        Set<Integer> preEnterSet = getPreEnters(enter, enterIndex);

        int i = 0;
        while (exit[i] != enter[enterIndex]) {
            // 나보다 먼저 나간 사람 set
            if (!preEnterSet.contains(exit[i])) {
                // 나보다 먼저 들어온 사람 제외
                preExitSet.add(exit[i]);
            }
            i++;
        }

        for (int j = enterIndex + 1; j < enter.length; j++) {
            // 나 이후에 들어온 사람
            if (preExitSet.contains(enter[j])) {
                // 나 이후에 들어온 사람 + 이전에 나간 사람
                // 사이에 있는 모든 사람과 만났음
                for (int k = j; k > enterIndex; k--) {
                    metSet.add(enter[k]);
                }
                preExitSet.remove(enter[j]);
            }
        }

        for (int met : metSet) {
            // 상대방 + 1
            answer[met - 1]++;
        }
        // 본인 + size
        answer[enter[enterIndex] - 1] += metSet.size();
    }

    private Set<Integer> getPreEnters(int[] enter, int standardIndex) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < standardIndex; i++) {
            result.add(enter[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
package org.codingtest.inflearn.st.p6;

import java.util.*;

class Solution {
    public int solution(int[] tasks, long k) {
        int answer = 0;

        int[] sorted = Arrays.copyOf(tasks, tasks.length);
        int queueIndex = 0;
        int queueSize = sorted.length;

        Arrays.sort(sorted);

        while (k > 0) {
            if ((long) sorted[queueIndex] * queueSize <= k) {
                k -= (long) sorted[queueIndex] * queueSize;
                queueIndex++;
                if (queueIndex < sorted.length) {
                    sorted[queueIndex] -= sorted[queueIndex - 1];
                }
                queueSize--;
            } else {
                k %= queueSize;

            }
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}

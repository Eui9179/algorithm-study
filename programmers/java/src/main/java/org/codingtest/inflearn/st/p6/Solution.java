package org.codingtest.inflearn.st.p6;

import java.util.*;

class Solution {
    public int solution(int[] tasks, long k) {
        int[] sT = copy(tasks);
        int size = tasks.length;
        int lastT = 0;

        Arrays.sort(sT);

        for (int i = 1; i < sT.length; i++) {
            long cycle = (long)(sT[i] - sT[i - 1]) * size;
            if (cycle <= k) {
                k -= cycle;
                size--;
            } else {
                lastT = sT[i];
                break;
            }
        }

        k %= size;
        if (k == 0) return tasks.length;

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] < lastT) continue;
            if (k == 0) return i + 1;
            k--;
        }
        return 0;
    }

    public int[] copy(int[] tasks) {
        int[] result = new int[tasks.length + 1];
        for (int i = 0; i < tasks.length; i++) {
            result[i + 1] = tasks[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}

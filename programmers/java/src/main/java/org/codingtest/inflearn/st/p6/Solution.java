package org.codingtest.inflearn.st.p6;

import java.util.*;

class Solution {
    public int solution(int[] tasks, long k) {
        int[] sT = copy(tasks); // 앞에 0을 넣고 배열 복사
        int size = tasks.length;
        int lastT = 0;

        Arrays.sort(sT);

        for (int i = 1; i < sT.length; i++) {
            // 가장 작은 값부터 사이클을 체크하며 순환
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
            if (tasks[i] < lastT) continue; // 마지막으로 처리했던 task 값보다 작으면 무시(이미 0으로 변경됨)
            if (k == 0) return i + 1;
            k--;
        }

        return 0;
    }

    public int[] copy(int[] tasks) {
        int[] result = new int[tasks.length + 1];
        System.arraycopy(tasks, 0, result, 1, tasks.length);
        return result;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}

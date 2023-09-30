package org.codingtest.inflearn.ds.p5;

import java.util.*;

class Solution {
    public int[] solution(int[][] tasks) {
        int[] answer = {};

        // 실행시간이 가장 작은 작업 먼저 처리
        // 같은 경우 작업번호가 작은 것 먼저 처리
        // 5초에 끝나면 5초에 실행
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        int time = 0;

        for (int i = 0; i < tasks.length; i++) {
            taskQueue.add(new Task(i, tasks[i][0], tasks[i][1]));
        }

        System.out.println(taskQueue);

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }

    static class Task implements Comparable<Task> {
        int index;
        int callTime;
        int executeTime;

        Task(int index, int callTime, int executeTime) {
            this.index = index;
            this.callTime = callTime;
            this.executeTime = executeTime;
        }

        @Override
        public int compareTo(Task t) {
            if (this.executeTime == t.executeTime) {
                return this.index - t.index;
            }
            return this.executeTime - t.executeTime;
        }

        @Override
        public String toString() {
            return "{" +
                    "index=" + index +
                    ", callTime=" + callTime +
                    ", executeTime=" + executeTime +
                    '}';
        }
    }
}
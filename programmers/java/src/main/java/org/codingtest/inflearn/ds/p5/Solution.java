package org.codingtest.inflearn.ds.p5;

import java.util.*;

class Solution {
    public int[] solution(int[][] tasks) {
        int[] answer = new int[tasks.length];

        PriorityQueue<Program> sortedPrograms = new PriorityQueue<>();
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        int time = 0;
        int index = 0;

        for (int i = 0; i < tasks.length; i++) {
            sortedPrograms.offer(new Program(i, tasks[i][0], tasks[i][1]));
        }

        while (!sortedPrograms.isEmpty() || !taskQueue.isEmpty()) {
            while (!sortedPrograms.isEmpty() && time >= sortedPrograms.peek().callTime) {
                taskQueue.offer(Task.of(sortedPrograms.poll()));
            }

            if (taskQueue.isEmpty()) {
                time++;
                continue;
            }

            Task task = taskQueue.poll();
            time += task.executeTime;

            answer[index] = task.index;
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }

    static class Program implements Comparable<Program> {
        int index;
        int callTime;
        int executeTime;

        Program(int index, int callTime, int executeTime) {
            this.index = index;
            this.callTime = callTime;
            this.executeTime = executeTime;
        }

        @Override
        public int compareTo(Program t) {
            if (this.callTime == t.callTime) {
                if (this.executeTime == t.executeTime) {
                    return this.index - t.index;
                }
                return this.executeTime - t.executeTime;
            }
            return this.callTime - t.callTime;
        }
    }

    static class Task implements Comparable<Task> {
        int index;
        int executeTime;

        Task(int index, int executeTime) {
            this.index = index;
            this.executeTime = executeTime;
        }

        static Task of(Program program) {
            return new Task(program.index, program.executeTime);
        }

        @Override
        public int compareTo(Task t) {
            if (this.executeTime == t.executeTime) {
                return this.index - t.index;
            }
            return this.executeTime - t.executeTime;
        }
    }
}
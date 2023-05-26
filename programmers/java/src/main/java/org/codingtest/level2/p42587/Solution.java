package org.codingtest.level2.p42587;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            tasks.add(Task.of(i, priorities[i]));
        }

        while (tasks.size() > 0) {
            Task task = tasks.get(0);
            Task firstTask = Collections.max(tasks, (t1, t2) -> t1.priority - t2.priority);

            if (task.priority < firstTask.priority) {
                tasks.add(tasks.remove(0));
            } else {
                answer++;
                if (task.index == location) {
                    return answer;
                }
                tasks.remove(0);
            }
        }
        return answer;
    }

    static class Task {
        int index;
        int priority;

        Task(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        static Task of(int index, int priority) {
            return new Task(index, priority);
        }
    }
}

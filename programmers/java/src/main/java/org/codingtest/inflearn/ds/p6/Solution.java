package org.codingtest.inflearn.ds.p6;

import java.util.*;

class Solution {
    public int solution(int n, int[][] meetings){
        int answer = 0;
        int time = 0;
        int[] record = new int[n];
        int[] rooms = new int[n];

        PriorityQueue<Meeting> meetingQueue = new PriorityQueue<>();
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        for (int i = 0; i < meetings.length; i++) {
            // 미팅 룸에 전부 삽입
            Meeting meeting = new Meeting(i, meetings[i][0], meetings[i][1]);
            meetingQueue.add(meeting);
        }

        while (!meetingQueue.isEmpty() || !taskQueue.isEmpty()) {
            // 미팅 룸과 예약 작업이 남을 때까지 반복
            while (!meetingQueue.isEmpty() && meetingQueue.peek().startTime <= time) {
                // 현재 시간보다 작으면 전부 작업 큐에 넣음
                taskQueue.add(Task.of(meetingQueue.poll()));
            }

            time++;
            
            for (int i = 0; i < rooms.length; i++) {
                // 방 남은 시간 계산
                if (rooms[i] > 0) rooms[i]--; // 시간 하나 줄임
                if (taskQueue.isEmpty()) continue;
                if (rooms[i] == 0) {
                    // 빈 방이라면 사용 시간을 넣음
                    Task task = taskQueue.poll();
                    rooms[i] = task.endTime - task.startTime;
                    record[i]++; // 방 사용 개수
                }
            }
        }

        int max = 0;
        for (int i = 0; i < record.length; i++) {
            if (max < record[i]) {
                answer = i;
                max = record[i];
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }

    static class Meeting implements Comparable<Meeting> {
        int index;
        int startTime;
        int endTime;

        public Meeting(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting m) {
            return this.startTime - m.startTime;
        }
    }

    static class Task implements Comparable<Task> {
        int index;
        int startTime;
        int endTime;

        public Task(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        static Task of(Meeting meeting) {
            return new Task(meeting.index, meeting.startTime, meeting.endTime);
        }

        @Override
        public int compareTo(Task t) {
            return this.index - t.index;
        }
    }
}
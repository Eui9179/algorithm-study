package org.codingtest.level1.p388351;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{700, 800, 1100},
                new int[][]{{710, 2359, 1050, 700, 650, 631, 659},
                        {800, 801, 805, 800, 759, 810, 809},
                        {1105, 1001, 1002, 600, 1059, 1001, 1100}},
                5)
        );
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            boolean isOk = true;
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100;
            minute += 10;
            if (minute >= 60) {
                minute -= 60;
                hour++;
            }
            int day = startday;
            for (int log : timelogs[i]) {
                if (day == 6) {
                    day++;
                    continue;
                } else if (day == 7) {
                    day = 1;
                    continue;
                }
                int logHour = log / 100;
                int logMinute = log % 100;
                if ((hour < logHour) || (hour == logHour && minute < logMinute)) {
                    isOk = false;
                    break;
                }
                day++;
            }
            if (isOk) answer++;
        }
        return answer;
    }
}
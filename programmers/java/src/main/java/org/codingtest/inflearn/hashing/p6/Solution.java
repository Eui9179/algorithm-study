package org.codingtest.inflearn.hashing.p6;

import java.util.*;

class Solution {
    public String[] solution(String[] reports, String times) {
        List<Report> answer = new ArrayList<>();
        String[] sTime = times.split(" ");
        String[] start = sTime[0].split(":");
        String[] end = sTime[1].split(":");

        int startTime = 60 * Integer.parseInt(start[0]) + Integer.parseInt(start[1]);
        int endTime = 60 * Integer.parseInt(end[0]) + Integer.parseInt(end[1]);

        for (String report : reports) {
            String[] sReport = report.split(" ");
            String[] sReportTime = sReport[1].split(":");
            int time = 60 * Integer.parseInt(sReportTime[0]) + Integer.parseInt(sReportTime[1]);

            Report r = new Report(sReport[0], time);

            if (startTime <= time && time <= endTime) {
                answer.add(r);
            }
        }
        Collections.sort(answer);
        return answer.stream().map(a -> a.name).toArray(String[]::new);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }

    static class Report implements Comparable<Report> {
        String name;
        int time;

        Report(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Report report) {
            return this.time - report.time;
        }
    }
}
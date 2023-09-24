package org.codingtest.inflearn.hashing.p6;

import java.util.*;

class Solution {
    public String[] solution(String[] reports, String times) {
        List<Report> answer = new ArrayList<>();
        String[] sTime = times.split(" ");
        String[] start = sTime[0].split(":");
        String[] end = sTime[1].split(":");

        int startHour = Integer.parseInt(start[0]);
        int startMinute = Integer.parseInt(start[1]);

        int endHour = Integer.parseInt(end[0]);
        int endMinute = Integer.parseInt(end[1]);

        for (String report : reports) {
            String[] sReport = report.split(" ");
            String person = sReport[0];
            String time = sReport[1];

            String[] sReportTime = time.split(":");
            int hour = Integer.parseInt(sReportTime[0]);
            int minute = Integer.parseInt(sReportTime[1]);

            Report r = new Report(person, hour, minute);

            if (startHour < hour && hour < endHour) {
                answer.add(r);
            } else if (startHour == hour && (startMinute <= minute && minute < 60)) {
                answer.add(r);
            } else if (endHour == hour && (0 <= minute && minute <= endMinute)) {
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
        int hour;
        int minute;

        Report(String name, int hour, int minute) {
            this.name = name;
            this.hour = hour;
            this.minute = minute;
        }

        @Override
        public int compareTo(Report report) {
            if (this.hour == report.hour) {
                return this.minute - report.minute;
            }
            return this.hour - report.hour;
        }
    }
}
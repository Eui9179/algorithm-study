package org.codingtest.inflearn.hashing.p7;

import java.util.*;

class Solution {
    public String[] solution(String[] reports, int time) {
        Set<String> personSet = new HashSet<>();
        Map<String, String> inAndOutMap = new HashMap<>();
        Map<String, Integer> recordTimeMap = new HashMap<>();

        for (String report : reports) {
            String[] sReport = report.split(" ");
            String name = sReport[0];
            String reportTime = sReport[1];
            String status = sReport[2];

            if (personSet.contains(name)) continue;

            if (status.equals("in")) {
                inAndOutMap.put(name, reportTime);
                continue;
            }

            String inTime = inAndOutMap.get(name);
            String[] sInTime = inTime.split(":");

            String[] sOutTime = reportTime.split(":");
            int inTimestamp = (60 * Integer.parseInt(sInTime[0])) + Integer.parseInt(sInTime[1]);
            int outTimestamp = (60 * Integer.parseInt(sOutTime[0])) + Integer.parseInt(sOutTime[1]);

            recordTimeMap.put(name, recordTimeMap.getOrDefault(name, 0) + (outTimestamp - inTimestamp));
            if (recordTimeMap.get(name) > time) personSet.add(name);
        }

        String[] answer = personSet.toArray(String[]::new);
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
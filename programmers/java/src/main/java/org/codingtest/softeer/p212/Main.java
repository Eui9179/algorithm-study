package org.codingtest.softeer.p212;

import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, ArrayList<Integer>> roomInfo = initRoomInfo(sc, n);
        removeNotAvailableTime(sc, m, roomInfo);

        showAvailableRoomInfo(roomInfo);
    }

    private static void showAvailableRoomInfo(Map<String, ArrayList<Integer>> roomInfo) {
        List<String> sortedRoomNames = new ArrayList<>(roomInfo.keySet());
        Collections.sort(sortedRoomNames);

        for (int i = 0 ; i < sortedRoomNames.size(); i++) {
            System.out.println("Room " + sortedRoomNames.get(i) + ":");
            showAvailableInfo(roomInfo.get(sortedRoomNames.get(i)));
            if (i < sortedRoomNames.size() - 1) {
                System.out.println("-----");
            }
        }
    }

    private static void showAvailableInfo(List<Integer> times) {
        List<String> availableTimes = new ArrayList<>();

        int i = 0;

        while(i < times.size()) {
            int startTime = times.get(i);
            int j = i + 1;

            while (j < times.size() && times.get(j) - 1 == times.get(j - 1)) {
                j++;
            }

            availableTimes.add(generateTimeString(startTime, times.get(j - 1) + 1));
            i = j;
        }

        if (availableTimes.size() == 0) {
            System.out.println("Not available");
            return;
        }

        System.out.println(availableTimes.size() + " available:");

        for (String time: availableTimes) {
            System.out.println(time);
        }
    }

    private static Map<String, ArrayList<Integer>> initRoomInfo(Scanner sc, int n) {
        Map<String, ArrayList<Integer>> roomInfo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String roomName = sc.next();
            roomInfo.put(roomName, new ArrayList<>());

            for (int time = 9; time < 18; time++) {
                roomInfo.get(roomName).add(time);
            }
        }

        return roomInfo;
    }

    private static void removeNotAvailableTime(
            Scanner sc,
            int m,
            Map<String, ArrayList<Integer>> roomInfo
    ) {
        for (int i = 0; i < m; i++) {
            String roomName = sc.next();
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();

            removeNotAvailableTimeByRoomName(roomInfo, roomName, startTime, endTime);
        }
    }

    private static void removeNotAvailableTimeByRoomName(
            Map<String, ArrayList<Integer>> roomInfo,
            String roomName,
            int startTime,
            int endTime
    ) {
        List<Integer> times = roomInfo.get(roomName);
        for (int i = startTime; i < endTime; i++) {
            times.remove(Integer.valueOf(i));
        }
    }

    private static String generateTimeString(int startTime, int endTime) {
        return startTime < 10 ? "0" + startTime + "-" + endTime : startTime + "-" + endTime;
    }
}
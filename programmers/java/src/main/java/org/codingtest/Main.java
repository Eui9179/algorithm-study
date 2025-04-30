package org.codingtest;

import java.util.*;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        List<String> workers = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O");
        Map<String, String> lastShift = new HashMap<>();
        Map<String, Integer> restDaysCount = new HashMap<>();
        for (String worker : workers) restDaysCount.put(worker, 0);

        Map<LocalDate, Map<String, List<String>>> schedule = new HashMap<>();
        LocalDate startDate = LocalDate.of(2025, 4, 1);
        LocalDate endDate = LocalDate.of(2025, 4, 30);
        Random random = new Random();

        Map<String, int[]> workforce = Map.of(
                "MONDAY", new int[]{5, 5}, "TUESDAY", new int[]{5, 5}, "WEDNESDAY", new int[]{5, 5}, "THURSDAY", new int[]{5, 5},
                "FRIDAY", new int[]{6, 7}, "SATURDAY", new int[]{7, 8}, "SUNDAY", new int[]{7, 8}
        );

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            String weekday = date.getDayOfWeek().name();
            int[] counts = workforce.get(weekday);
            List<String> available = new ArrayList<>(workers);

            available.removeIf(w -> "오후근무".equals(lastShift.get(w)));
            Collections.shuffle(available, random);
            List<String> morningShift = available.subList(0, counts[0]);

            available = new ArrayList<>(workers);
            available.removeAll(morningShift);
            Collections.shuffle(available, random);
            List<String> afternoonShift = available.subList(0, counts[1]);

            List<String> restShift = new ArrayList<>(workers);
            restShift.removeAll(morningShift);
            restShift.removeAll(afternoonShift);

            for (String r : restShift) restDaysCount.put(r, restDaysCount.get(r) + 1);
            for (String w : workers) lastShift.put(w, restShift.contains(w) ? "휴무" : (morningShift.contains(w) ? "오전근무" : "오후근무"));

            schedule.put(date, Map.of("오전근무", morningShift, "오후근무", afternoonShift, "휴무", restShift));
        }

        schedule.forEach((date, shifts) -> {
            System.out.println(date + " " + shifts);
        });
    }
}


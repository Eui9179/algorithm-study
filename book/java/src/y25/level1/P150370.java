package y25.level1;

import java.util.*;

class P150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> termMap = new HashMap<>();
        for (String term: terms) {
            String[] t = term.split(" ");
            String title = t[0];
            int month = Integer.parseInt(t[1]);
            termMap.put(title, month);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String date = privacy[0];
            String title = privacy[1];

            int month = termMap.get(title);
            if (isBefore(addMonth(date, month), today)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private boolean isBefore(String date, String today) {
        String[] date1 = date.split("\\.");
        int y = Integer.parseInt(date1[0]);
        int m = Integer.parseInt(date1[1]);
        int d = Integer.parseInt(date1[2]);

        String[] todaySplit = today.split("\\.");
        int todayY = Integer.parseInt(todaySplit[0]);
        int todayM = Integer.parseInt(todaySplit[1]);
        int todayD = Integer.parseInt(todaySplit[2]);

        System.out.println(date + ", " + today);
        if (y < todayY) return true;
        if (y > todayY) return false;
        if (m < todayM) return true;
        if (m > todayM) return false;
        if (d < todayD) return true;
        return d <= todayD;
    }

    private String addMonth(String date, int month) {
        String[] dateSplit = date.split("\\.");
        int y = Integer.parseInt(dateSplit[0]);
        int m = Integer.parseInt(dateSplit[1]);
        int nextMonth = m + month;
        while (nextMonth > 12) {
            nextMonth -= 12;
            y++;
        }
        return y + "." + nextMonth + "." + dateSplit[2];
    }
}

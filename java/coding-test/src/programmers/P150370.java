package programmers;

import java.util.*;

public class P150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        List<Integer> compDates = new ArrayList<>();

        for (String term : terms) {
            String[] kv = term.split(" ");
            String key = kv[0];
            Integer value = Integer.parseInt(kv[1]);
            termsMap.put(key, value);
        }

        for (String privacy : privacies) {
            String[] pSplit = privacy.split(" ");

            String date = pSplit[0];
            System.out.println("today = " + today);
            System.out.println("date = " + date);
            String pri = pSplit[1];
            int calcMonth = termsMap.get(pri);
            compDates.add(calcDate(date, calcMonth));
        }

        int calcToday = calcDate(today, 0);

        for (int i = 0; i < compDates.size(); i++) {
            System.out.println("calcToday = " + calcToday);
            System.out.println("compDates = " + compDates.get(i));

            if (compDates.get(i) <= calcToday) {
                result.add(i + 1);
            }
        }

        System.out.println("result = " + result);

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int calcDate(String date, int month) {
        String[] dateSplit = date.split("[.]");
        int curY = Integer.parseInt(dateSplit[0]);
        int curM = Integer.parseInt(dateSplit[1]);
        int curD = Integer.parseInt(dateSplit[2]);

        return (curY * 12 * 28) + ((curM  + month) * 28) + curD;
    }

    public static void main(String[] args) {
        new P150370().solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
//        new P150370().solution("2021.12.08", new String[]{"A 18"}, new String[]{"2020.06.08 A"});
//        new P150370().solution(
//                "2020.01.01",
//                new String[]{"Z 3", "D 5"},
//                new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}
//        );
    }
}

package programmers;

import com.sun.tools.javac.Main;

import java.util.*;

public class P150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 모든 달은 28일
        // today 2022.05.19 yyyy.mm.dd 형태
        // ["A 6", "B 12", "C 3"]
        // ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        List<String> compDates = new ArrayList<>();

        for (String term : terms) {
            String[] kv = term.split(" ");
            String key = kv[0];
            Integer value = Integer.parseInt(kv[1]);
            termsMap.put(key, value);
        }

        for (String privacy : privacies) {
            String[] pSplit = privacy.split(" ");
            String date = pSplit[0];
            String pri = pSplit[1];
            Integer calcMonth = termsMap.get(pri);
            compDates.add(calcDate(date, calcMonth));
        }

        for (int i = 0; i < compDates.size(); i++) {
            if (isDelete(today, compDates.get(i))) {
                result.add(i + 1);
            }
        }

        System.out.println("result = " + result);

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static String calcDate(String date, Integer month) {
        String[] dateSplit = date.split("[.]");
        int curY = Integer.parseInt(dateSplit[0]);
        int curM = Integer.parseInt(dateSplit[1]);
        int curD = Integer.parseInt(dateSplit[2]);

        int mon = ((month * 28) + (curD - 1)) / 28;
        int day = ((month * 28) + (curD - 1)) % 28 ;

        curY += (curM + mon) / 12;;
        curM = (curM + mon) % 12;
        curD = day;
        if (curD == 0) {
            curM--;
            curD = 28;
        }
        if (curM <= 0) {
            curY--;
            curM = 12 + curM;
        }


        return curY + "." + curM + "." + curD;
    }

    public static boolean isDelete(String today, String compDate) {
        System.out.println("today = " + today);
        System.out.println("compDate = " + compDate);
        String[] todays = today.split("[.]");
        int toY = Integer.parseInt(todays[0]);
        int toM = Integer.parseInt(todays[1]);
        int toD = Integer.parseInt(todays[2]);

        String[] compDates = compDate.split("[.]");
        int compY = Integer.parseInt(compDates[0]);
        int compM = Integer.parseInt(compDates[1]);
        int compD = Integer.parseInt(compDates[2]);

        if (toY > compY) {
            return true;
        }

        if (toY == compY && toM > compM) {
            return true;
        }


        if (toY == compY && toM == compM && toD > compD) {
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
//        new P150370().solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
        new P150370().solution("2021.12.08", new String[]{"A 18"}, new String[]{"2020.06.08 A"});
//        new P150370().solution(
//                "2020.01.01",
//                new String[]{"Z 3", "D 5"},
//                new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}
//        );
    }
}

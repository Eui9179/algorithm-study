package y24.test.test2;

import java.util.*;

public class Solution {
    public int solution(String[] kor, String[] usa, String[] incs) {
        Map<String, Integer> korUsaMap = new HashMap<>();
        Map<String, ArrayList<String>> dailyIncKor = new HashMap<>();
        Map<String, ArrayList<String>> dailyIncUsa = new HashMap<>();

        for (int i = 0; i < incs.length; i++) {
            dailyIncKor.put(String.valueOf(i), new ArrayList<>());
            dailyIncUsa.put(String.valueOf(i), new ArrayList<>());
        }

        generateDailyMap(incs, kor, dailyIncKor, dailyIncUsa);

        for (String day : dailyIncKor.keySet()) {
            ArrayList<String> korCompanies = dailyIncKor.get(day);
            for (String korCompany : korCompanies) {
                for (String usaCompany : dailyIncUsa.get(day)) {
                    String key = korCompany + "-" + usaCompany;
                    if (korUsaMap.containsKey(key)) {
                        Integer value = korUsaMap.get(key);
                        korUsaMap.put(key, value + 1);
                    } else {
                        korUsaMap.put(key, 1);
                    }
                }
            }
        }
        return Collections.max(korUsaMap.values());
    }

    public void generateDailyMap(String[] incs, String[] kor,
                                 Map<String, ArrayList<String>> dailyIncKor,
                                 Map<String, ArrayList<String>> dailyIncUsa) {
        for (int i = 0; i < incs.length; i++) {
            String[] dailyInc = incs[i].split(" ");
            for (String company : dailyInc) {
                if (Arrays.asList(kor).contains(company)) {
                    dailyIncKor.get(String.valueOf(i)).add(company);
                } else {
                    dailyIncUsa.get(String.valueOf(i)).add(company);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] kor = {"AAA", "BCD", "AAAAA", "ZY"};
        String[] usa = {"AB", "AA", "TTTT"};
        String[] incs = {
                "AB BCD AA AAA TTTT AAAAA",
                "BCD AAA",
                "AB AAA TTTT BCD",
                "AA AAAAA AB",
                "AAA AB BCD"
        };
        System.out.println(new Solution().solution(kor, usa, incs));


    }

}

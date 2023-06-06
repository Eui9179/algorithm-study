package org.codingtest.level2.p92341;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        new Solution().solution(new int[]{180, 5000, 10, 600}, new String[]{
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        });
    }
    public int[] solution(int[] fees, String[] records) {
        /*
        1. 출차 내역이 없으면 23:59로 계산
        2.
         */
        int[] answer = {};

        // map을 이용 in만 넣음

        Map<String, String> inRecord = new HashMap<>();
        Map<String, String> outRecord = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        ArrayList<String> keys;

        for (String r : records) {
            String[] splitR = r.split(" ");
            if (splitR[2].equals("IN")) {
                inRecord.put(splitR[1], splitR[0]);
            } else {
                outRecord.put(splitR[1], splitR[0]);
            }
        }

        keys = new ArrayList<>(inRecord.keySet());
        Collections.sort(keys);

        for (String key : inRecord.keySet()) {
            String inTime = inRecord.get(key);
            String outTime = "23:59";

            if (outRecord.containsKey(key))
                outTime = outRecord.get(key);

            result.put(key, calcPrice(inTime, outTime, fees));
        }

        for (String key : keys) {
            System.out.println(result.get(key));;
        }

        return answer;
    }

    public int calcPrice(String inTime, String outTime, int[] fees) {
        int minute, sih, soh, sim, som;
        String[] si = inTime.split(":");
        String[] so = outTime.split(":");

        sih = Integer.parseInt(si[0]);
        soh = Integer.parseInt(so[0]);

        sim = Integer.parseInt(si[1]);
        som = Integer.parseInt(so[1]);

        if (sim > som) {
            soh--;
            som += 60;
        }


        System.out.println(som);
        System.out.println(sim);
        System.out.println(soh);
        System.out.println(sih);
        System.out.println();
        minute = som - sim;
        minute += (soh - sih) * 60;

        return fees[0] + ((minute - fees[1]) / fees[2]) * fees[3];
    }
}
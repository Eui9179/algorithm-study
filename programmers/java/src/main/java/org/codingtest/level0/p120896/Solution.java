package org.codingtest.level0.p120896;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String s) {
        Map<String, Integer> strMap = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
        String[] strArr = s.split("");

        for (String str : strArr) {
            if (strMap.containsKey(str)) {
                strMap.put(str, 1);
            } else {
                strMap.put(str, strMap.get(str) + 1);
            }
        }

        for (String str : strMap.keySet()) {
            if (strMap.get(str) == 1) {
                answer.add(str);
            }
        }
        Collections.sort(answer);

        return String.join("", answer);
    }
}


package org.codingtest.level2.p42578;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}}));
    }
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, ArrayList<String>> combi = new HashMap<>();

        for (String[] cloth : clothes) {
            if (combi.containsKey(cloth[1])) {
                combi.get(cloth[1]).add(cloth[0]);
            } else {
                combi.put(cloth[1], new ArrayList<>(Arrays.asList(cloth[0], "")));
            }
        }

        for (String key : combi.keySet()) {
            answer *= combi.get(key).size();
        }

        System.out.println(combi);

        return answer - 1;
    }
}

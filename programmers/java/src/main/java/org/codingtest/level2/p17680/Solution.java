package org.codingtest.level2.p17680;

import java.util.*;

class Solution {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        String cityPlain;
        ArrayList<String> cache = new ArrayList<>();

        for (String city: cities) {
            cityPlain = city.toLowerCase();
            if (cache.contains(cityPlain)) {
                cache.remove(cityPlain);
                cache.add(cityPlain);
                answer++;
            } else {
                answer += 5;
                if (cacheSize == 0) continue;

                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }
                cache.add(cityPlain);
            }
        }

        return answer;
    }
}

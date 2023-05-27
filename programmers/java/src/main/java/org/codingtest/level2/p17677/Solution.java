package org.codingtest.level2.p17677;

import java.util.*;

class Solution {
    public final int NUM = 65536;

    public int solution(String str1, String str2) {
        int A, B;
        Map<String, Integer> map1 = stringToMap(str1);
        Map<String, Integer> map2 = stringToMap(str2);

        if (map1.keySet().size() == 0 && map2.keySet().size() == 0) {
            return NUM;
        }

        A = retain(map1, map2);
        B = add(map1, map2);

        return (int) (((float) A / (float) B) * NUM);
    }

    public Map<String, Integer> stringToMap(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        char[] charKey = new char[2];
        String key;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length - 1; i++) {
            if (!Character.isAlphabetic(chars[i]) || !Character.isAlphabetic(chars[i + 1])) {
                continue;
            }
            charKey[0] = chars[i];
            charKey[1] = chars[i + 1];
            key = String.valueOf(charKey);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        return map;
    }

    public int retain(Map<String, Integer> map1, Map<String, Integer> map2) {
        Set<String> setA = new HashSet<>(map1.keySet());
        Set<String> setB = new HashSet<>(map2.keySet());
        setA.retainAll(setB);
        return setA.stream()
                .map(key -> Math.min(map1.get(key), map2.get(key)))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int add(Map<String, Integer> map1, Map<String, Integer> map2) {
        int result = 0;
        Set<String> setA = new HashSet<>(map1.keySet());
        Set<String> setB = new HashSet<>(map2.keySet());

        setA.addAll(setB);

        for (String key : setA) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                result += Math.max(map1.get(key), map2.get(key));
            } else if (map1.containsKey(key)) {
                result += map1.get(key);
            } else {
                result += map2.get(key);
            }
        }
        return result;
    }
}
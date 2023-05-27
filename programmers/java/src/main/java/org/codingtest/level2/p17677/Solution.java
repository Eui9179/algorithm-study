package org.codingtest.level2.p17677;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("handshake", "shake hands"));
    }

    public int solution(String str1, String str2) {
        int A = 0, B = 0;
        Map<String, Integer> map1 = stringToMap(str1);
        Map<String, Integer> map2 = stringToMap(str2);

        if (map1.keySet().size() == 0 && map2.keySet().size() == 0) {
            return 65536;
        }

        Set<String> set1 = new HashSet<>(map1.keySet());
        Set<String> set2 = new HashSet<>(map2.keySet());

        set1.retainAll(set2);

        for (String key : set1) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                A += Math.min(map1.get(key), map2.get(key));
            } else if (map1.containsKey(key)) {
                A += map1.get(key);
            } else {
                A += map2.get(key);
            }
        }

        Set<String> set3 = new HashSet<>(map1.keySet());
        Set<String> set4 = new HashSet<>(map2.keySet());

        set3.addAll(set4);

        for (String key : set3) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                B += Math.max(map1.get(key), map2.get(key));
            } else if (map1.containsKey(key)) {
                B += map1.get(key);
            } else {
                B += map2.get(key);
            }
        }
        return (int) (((float) A / (float) B) * 65536);
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
}
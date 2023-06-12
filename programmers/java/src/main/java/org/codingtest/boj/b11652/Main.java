package org.codingtest.boj.b11652;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Long answer = 0L;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = -1;
        Map<Long, Integer> map = new HashMap<>();

        for (long i = 0; i < n; i++) {
            Long key = sc.nextLong();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        List<Long> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (Long key : keys) {
            if (result < map.get(key)) {
                result = map.get(key);
                answer = key;
            }
        }
        System.out.println(answer);
    }
}

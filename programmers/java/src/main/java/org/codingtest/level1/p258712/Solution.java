package org.codingtest.level1.p258712;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Solution {
    public static void main(String[] args) {
        Map<String, Long> freq = new HashMap<>();
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());
    }
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int[][] tables = new int[friends.length][friends.length];
        int[] giftScore = new int[friends.length];

        Map<String, Integer> index = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            index.put(friends[i], i);
        }

        for (String gift: gifts) {
            String[] fromTo = gift.split(" ");
            String from = fromTo[0];
            String to = fromTo[1];

            tables[index.get(from)][index.get(to)]++;
            giftScore[index.get(from)]++;
            giftScore[index.get(to)]--;
        }

        for (int i = 0; i < tables.length; i++) {
            int result = 0;
            for (int j = 0; j < tables.length; j++) {
                if (i == j) continue;
                if (tables[i][j] > tables[j][i]) result++;
                else if (tables[i][j] == tables[j][i] && giftScore[i] > giftScore[j]) result++;
            }

            answer = Math.max(answer, result);
        }

        return answer;
    }
}
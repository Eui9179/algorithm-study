package org.codingtest.inflearn.hashing.p5;

import java.util.*;
class Solution {
    public String solution(String[] votes, int k){
        Map<String, Set<String>> map = generateVoteMap(votes);
        Map<String, Integer> countSet = generateCountMap(map, k);
        return getMaxGivenGift(countSet);
    }

    private String getMaxGivenGift(Map<String, Integer> countSet) {
        String person = "";
        int max = -1;
        for (String key : countSet.keySet()) {
            if (max < countSet.get(key)) {
                max = countSet.get(key);
                person = key;
            } else if (max == countSet.get(key)){
                person = person.compareTo(key) > 0 ? key : person;
            }
        }
        return person;
    }

    private Map<String, Integer> generateCountMap(Map<String, Set<String>> map, int k) {
        Map<String, Integer> countSet = new HashMap<>();
        for (String voted: map.keySet()) {
            if (map.get(voted).size() < k) continue;

            for (String vote : map.get(voted)) {
                countSet.put(vote, countSet.getOrDefault(vote, 0) + 1);
            }
        }
        return countSet;
    }
    private Map<String, Set<String>> generateVoteMap(String[] votes) {
        Map<String, Set<String>> map = new HashMap<>();

        for (String vote: votes) {
            String[] split = vote.split(" ");
            String from = split[0];
            String to = split[1];

            if (!map.containsKey(to)) {
                map.put(to, new HashSet<>());
            }

            map.get(to).add(from);
        }

        return map;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
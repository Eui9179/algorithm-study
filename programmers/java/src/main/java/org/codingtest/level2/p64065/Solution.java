package org.codingtest.level2.p64065;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution("{{20,111},{111}}")));
    }

    public int[] solution(String s) {
        Map<Integer, Set<Integer>> map = new LinkedHashMap<>();
        s = s.replaceAll("},", "}");
        String[] strings = s.split("");

        Set<Integer> set = new HashSet<>();
        int count = 0;
        StringBuilder numStr = new StringBuilder();

        for (int i = 1; i < strings.length - 1; i++) {
            switch (strings[i]) {
                case "{" -> set = new HashSet<>();
                case "," -> {
                    set.add(Integer.parseInt(numStr.toString()));
                    count++;
                    numStr = new StringBuilder();
                }
                case "}" -> {
                    set.add(Integer.parseInt(numStr.toString()));
                    map.put(count + 1, set);
                    numStr = new StringBuilder();
                    count = 0;
                }
                default -> numStr.append(strings[i]);
            }
        }

        int[] answer = new int[map.size()];
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort(Collections.reverseOrder());
        for (Integer key : keys) {
            if (key == 1) {
                for (int num : map.get(key)) {
                    answer[key - 1] = num;
                    break;
                }
            } else {
                map.get(key).removeAll(map.get(key - 1));
                for (int num : map.get(key)) {
                    answer[key - 1] = num;
                    break;
                }
            }

        }
        return answer;
    }
}

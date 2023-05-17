package org.codingtest.level2.p12981;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(
                3,
                new String[]{
                        "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
                })));
    }

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (wordSet.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            wordSet.add(words[i]);

            if (words[i - 1].charAt(words[i - 1].length() - 1) !=
                    words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = ((i + 1) / n) + 1;
                break;
            }
        }

        return answer;
    }
}

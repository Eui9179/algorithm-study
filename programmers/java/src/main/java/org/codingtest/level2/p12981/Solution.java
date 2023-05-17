package org.codingtest.level2.p12981;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            if (words[i].length() == 1) {
                return calcIndex(i, n);

            }
            if (wordSet.contains(words[i])) {
                return calcIndex(i, n);
            }

            wordSet.add(words[i]);

            if (words[i - 1].charAt(words[i - 1].length() - 1) !=
                    words[i].charAt(0)) {
                return calcIndex(i, n);
            }
        }

        return new int[]{0, 0};
    }

    public int[] calcIndex(int i, int n) {
        return new int[] {(i % n) + 1, (i / n) + 1};
    }
}

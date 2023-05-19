package org.codingtest.level2.p131701;

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int sum;

        Set<Integer> sets = new HashSet<>();
        int[] elementsTwice = copyTwice(elements);

        for (int i = 1; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += elementsTwice[j + k];
                }

                if (sets.contains(sum)) continue;
                sets.add(sum);
            }

            System.out.println(sets);
        }

        return sets.size() + 1;
    }

    public int[] copyTwice(int[] original) {
        int[] newArray = new int[(original.length * 2)];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < original.length; j++) {
                newArray[j + (i * original.length)] = original[j];
            }
        }
        return newArray;
    }
}
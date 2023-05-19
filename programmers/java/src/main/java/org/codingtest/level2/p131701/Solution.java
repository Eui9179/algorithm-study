package org.codingtest.level2.p131701;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{7,9,1,1,4}));
    }

    public int solution(int[] elements) {
        int sum;

        Set<Integer> sets = new HashSet<>();

        // 한개일 때, length 까지
        // 두개일 때, length + 1 까지
        // 세개일 때, length + 2 까지
        // ...
        // 다섯개일 때, length 까지 (마지막것만 예외로 처리?)

        // 최대 elements * 2 - 1개 필요

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
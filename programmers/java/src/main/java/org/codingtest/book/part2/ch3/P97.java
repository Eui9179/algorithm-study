package org.codingtest.book.part2.ch3;

import java.util.Arrays;

public class P97 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3, 1, 2}, {4, 1, 4}, {2, 2, 2}}));
        System.out.println(solution(new int[][]{{7, 3, 1, 8}, {3, 3, 3, 4}}));
    }

    public static int solution(int[][] cards) {

        int max = Integer.MIN_VALUE;

        for (int[] card : cards) {
            Arrays.sort(card);

            if (max < card[0]) {
                max = card[0];
            }
        }

        return max;
    }
}

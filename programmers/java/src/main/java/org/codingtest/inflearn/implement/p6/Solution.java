package org.codingtest.inflearn.implement.p6;

import java.util.*;

class Solution {
    public int solution(int[][] fruit){
        int answer = 0;

        run(fruit);

        int[] indices = new int[fruit.length];

        for (int i = 0; i < fruit.length; i++) {
            indices[i] = getMinimumFruit(fruit[i]);
        }

        for (int i = 0; i < indices.length; i++) {
            System.out.println(Arrays.toString(fruit[i]));

            answer += fruit[i][indices[i]];
        }

        return answer;
    }

    public void run(int[][] fruit) {
        boolean[] completed = new boolean[fruit.length];
        int[] indices = new int[fruit.length];

        for (int i = 0; i < fruit.length; i++) {
            indices[i] = getMinimumFruit(fruit[i]);
        }

        int[] A, B;
        for (int i = 0; i < fruit.length - 1; i++) {
            A = fruit[i];

            for (int j = i + 1; j < fruit.length; j++) {
                B = fruit[j];

                if (completed[i]) break;

                if (indices[i] == indices[j] || completed[j]) continue;

                completed[i] = true;
                completed[j] = true;

                A[indices[i]]++;
                B[indices[i]]--;

                A[indices[j]]--;
                B[indices[j]]++;
            }
        }
    }

    public int getMinimumFruit(int[] fruit) {
        int index = 0;
        for (int i = 1; i < fruit.length; i++) {
            if (fruit[index] > fruit[i]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}

package org.codingtest.inflearn.implement.p6;

import java.util.*;

class Solution {
    public int solution(int[][] fruit){
        int answer = 0;
        int[] indices = new int[fruit.length];

        for (int i = 0; i < fruit.length; i++) {
            indices[i] = getMinimumFruit(fruit[i]);
        }

        boolean[] check = new boolean[fruit.length];
        checkIrreplaceable(fruit, indices, check);

        run(fruit, indices, check);
        for (int i = 0; i < indices.length; i++) {
            answer += fruit[i][indices[i]];
        }

        return answer;
    }

    private void checkIrreplaceable(int[][] fruit, int[] indices, boolean[] check) {
        for (int i = 0; i < fruit.length; i++) {
            int min = fruit[i][indices[i]];
            int count = 0;
            for (int f : fruit[i]) {
                if (min == f) count++;
            }
            if (count > 1) check[i] = true;
        }
    }

    public void run(int[][] fruit, int[] indices, boolean[] check) {
        for (int i = 0; i < fruit.length - 1; i++) {
            if (check[i]) continue;

            for (int j = i + 1; j < fruit.length; j++) {
                if (check[i]) break;

                if (indices[i] == indices[j] || check[j]) continue;

                int AMin = fruit[i][indices[i]];
                int ASub = fruit[i][indices[j]];
                int BMin = fruit[j][indices[j]];
                int BSub = fruit[j][indices[i]];

                if (AMin + 1 == ASub || BMin + 1 == BSub) {
                    continue;
                }

                check[i] = true;
                check[j] = true;

                fruit[i][indices[i]]++;
                fruit[i][indices[j]]--;
                fruit[j][indices[j]]++;
                fruit[j][indices[i]]--;
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

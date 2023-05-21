package org.codingtest.level2.p87390;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(3, 2, 5)));
    }

    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] result = new int[size];
        boolean end = false;
        long index;

        int startI = (int) (left / n);
        int endI = (int) (right / n);

        for (int i = startI; i < endI + 1; i++) {
            for (int j = 0; j < n; j++) {
                index = (i * (long) n) + j;

                if (index < left) {
                    continue;
                }

                else if (index > right) {
                    end = true;
                    break;
                }

                if (j < i + 1) {
                    result[(int) (index - left)] = i + 1;
                } else {
                    result[(int) (index - left)] = j + 1;
                }
            }
            if (end) {
                break;
            }
        }
        return result;
    }
}

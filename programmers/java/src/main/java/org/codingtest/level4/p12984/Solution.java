package org.codingtest.level4.p12984;

import java.util.*;

public class Solution {
    public long solution(int[][] land, int P, int Q) {
        // int[][] newLand = copy(land);
        List<String> s = new ArrayList<>();
        String ss = "asdf";

        return binarySearch(land, P, Q);

        // System.out.println();
        // processStandard(newLand, standard);
        // int[] pq = calcPQ(newLand, P, Q);

        // for (int k = 0; k < land.length; k ++) {
        // System.out.println(Arrays.toString(newLand[k]));
        // }
        // return pq[0] + pq[1];


    }

    public long binarySearch(int[][] land, int P, int Q) {
        int result = 1;
        int left = 1;
        int right = getMaxLand(land);
        int mid;
        int[] pq;
        long min = Long.MAX_VALUE;

        while (left <= right) {
            mid = (left + right) / 2;
            processStandard(land, mid);

            // (-)는 Q, (+)는 P
            // if Q < P ? (-) 가 많은 쪽으로 right = mid - 1;
            // if Q > P ? (+) 가 많은 쪽으로 left = mid + 1;
            pq = calcPQ(land, P, Q);

            if (pq[0] > pq[1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            if (pq[0] + pq[1] < min) { 
                min = pq[0] + pq[1];
            }
        }

        return min;
    }

    public int getMaxLand(int[][] land) {
        int n = land.length;
        int result = -1;
        for (int[] ints : land) {
            for (int j = 0; j < n; j++) {
                if (ints[j] > result) {
                    result = ints[j];
                }
            }
        }
        return result;
    }

    public void processStandard(int[][] land, int standard) {
        int n = land.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                land[i][j] = standard - land[i][j];
            }
        }
    }

    public int[] calcPQ(int[][] land, int P, int Q) {
        int p = 0;
        int q = 0;
        int n = land.length;
        for (int[] ints : land) {
            for (int j = 0; j < n; j++) {
                if (ints[j] < 0) {
                    q += Math.abs(ints[j]);
                } else if (ints[j] > 0) {
                    p += Math.abs(ints[j]);
                }
            }
        }
        return new int[]{p * P, q * Q};
    }

    public int[][] copy(int[][] land) {
        int n = land.length;
        int[][] newLand = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(land[i], 0, newLand[i], 0, n);
        }
        return newLand;
    }
}
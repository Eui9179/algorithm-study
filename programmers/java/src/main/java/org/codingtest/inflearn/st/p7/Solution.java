package org.codingtest.inflearn.st.p7;

import java.util.*;

class Solution {
    public int solution(int[][] meetings){
        int answer = 0;
        int time = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Arrays.sort(meetings, Comparator.comparingInt(m -> m[0]));

        for (int[] meeting : meetings) {
            if (time <= meeting[0]) {

            }
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
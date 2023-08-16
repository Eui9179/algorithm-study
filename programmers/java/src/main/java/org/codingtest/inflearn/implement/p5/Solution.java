package org.codingtest.inflearn.implement.p5;

import java.util.*;

class Solution {
    public int solution(int[] nums){
        int answer = 0;
        int count = 1;

        boolean increaseFlag = false;
        boolean decreaseFlag = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                if (!increaseFlag && !decreaseFlag) {
                    increaseFlag = true;
                    count = 2;
                } else if (increaseFlag) {
                    count++;
                } else {
                    answer = Math.max(answer, count);
                    count = 2;
                    decreaseFlag = false;
                    increaseFlag = true;
                }
            } else if (nums[i] > nums[i + 1]) {
                if (increaseFlag) {
                    increaseFlag = false;
                    decreaseFlag = true;
                    count++;
                } else if (decreaseFlag) {
                    count++;
                }
            } else {
                answer = Math.max(answer, count);
                count = 0;
                decreaseFlag = false;
                increaseFlag = false;
            }
        }

        if (decreaseFlag) {
            answer = Math.max(answer, count);
        }

        if (answer < 3) {
            return 0;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
package org.codingtest.inflearn.st.p1;

import java.util.*;

class Solution {
    public int[] solution(int[] nums){
        return Arrays.stream(nums).boxed().sorted((num1, num2) -> {
            int count1 = Integer.toString(num1, 2).replaceAll("0", "").length();
            int count2 = Integer.toString(num2, 2).replaceAll("0", "").length();
            if (count1 == count2) {
                return num1 - num2;
            }
            return count1 - count2;
        }).mapToInt(num -> num).toArray();
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
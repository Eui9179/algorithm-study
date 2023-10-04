package org.codingtest.inflearn.st.p2;

import java.util.*;

class Solution {
    public int[] solution(int[] nums){
//        int[] answer = new int[nums.length / 2];
        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        Arrays.sort(nums);

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (set.contains(num * 2)) answer.add(num);
            else set.remove(num);
        }
        
        return answer.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
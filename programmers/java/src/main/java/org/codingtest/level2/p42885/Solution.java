package org.codingtest.level2.p42885;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{30, 100, 45, 45, 70}, 100));
        // {30 45 45 70 100}
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        int l = 0;
        int h = people.length - 1;

        Arrays.sort(people);

        while (l <= h) {
            if (people[l] + people[h] <= limit) {
                l++;
                h--;
            } else if (people[l] + people[h] > limit) {
                h--;
            }
            answer++;
        }

        return answer;
    }
}
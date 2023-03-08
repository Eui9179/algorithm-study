package org.codingtest.level1.p12954;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public long[] solution(int x, int n) {
        ArrayList<Long> answer = new ArrayList<>();
        long xL = x;
        int count = 0;
        while (count < n) {
            answer.add(xL);
            xL += x;
            count++;
        }
        return answer.stream().mapToLong(Long::longValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(-4, 2)));
    }
}

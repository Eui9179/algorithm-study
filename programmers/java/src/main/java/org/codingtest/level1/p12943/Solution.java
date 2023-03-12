package org.codingtest.level1.p12943;

public class Solution {
    public int solution(int num) {
        long longNum = num;
        long answer = 0L;
        while (answer < 500 && longNum != 1) {
            if (longNum % 2 == 0) {
                longNum /= 2;
            } else {
                longNum = (longNum * 3) + 1;
            }
            answer++;
        }
        return answer == 500 ? -1 : (int)answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(626331));
    }
}

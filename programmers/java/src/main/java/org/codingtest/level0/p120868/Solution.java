package org.codingtest.level0.p120868;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int l = Math.max(sides[0], sides[1]);
        int s = Math.min(sides[0], sides[1]);
        for (int i = l + 1; i < s + l; i++) {
            answer++;
        }
        return answer + s;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{11, 7});
    }
}
package org.codingtest.c.test3;

class Solution {
    public static void main(String[] args) {
        new Solution().solution("abccbd", new int[]{0, 1, 2, 3, 4, 5});
        new Solution().solution("aabbcc", new int[]{1,2,1,2,1,2});
        new Solution().solution("aaaa", new int[]{3,4,5,6,});
        new Solution().solution("ababa", new int[]{10,5,10,5,10});
        new Solution().solution("", new int[]{10,5,10,5,10});
    }
    public int solution(String S, int[] C) {
        int answer = 0;
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                answer += Math.min(C[i], C[i + 1]);
            }
        }
        return answer;
    }
}

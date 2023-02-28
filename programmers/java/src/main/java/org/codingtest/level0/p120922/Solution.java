package org.codingtest.level0.p120922;

class Solution {
    public int solution(int M, int N) {
        int answer = M - 1;

        for (int i = 0; i < M; i++) {
            answer += N - 1;
        }
        answer = (M - 1) + ((N - 1) * M);
        // M - 1 + (NM - M)
        // NM - 1
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, 5));
    }
}

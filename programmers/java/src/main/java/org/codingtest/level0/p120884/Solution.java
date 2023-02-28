package org.codingtest.level0.p120884;

class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while (chicken >= 10) {
            int service = chicken / 10;
            int left = chicken % 10;

            chicken = service + left;
            answer += service;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(1081));
    }
}

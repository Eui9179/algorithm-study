package org.codingtest.level2.p12985;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0, parent = 0, d = n, t = 2, standard;

        while (d >= 1) {
            d = (n / t);
            standard = d + parent;

            if (a > standard && b > standard) { // A, B가 모두 오른쪽 그룹에 속할 때
                parent += d;
            }

            else if ((a <= standard && b > standard) || (a > standard && b <= standard)) {
                answer = (int) (Math.log((double) d * 2) / Math.log(2));
                break;
            }

            t *= 2;
        }
        return answer;
    }
}
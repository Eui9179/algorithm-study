package org.codingtest.level2.p12985;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0, preD = 0, d = n, t = 2, curD;

        while (d >= 1) {
            d = (n / t);
            curD = d + preD;

            if (a > curD && b > curD) { // 오른쪽 그룹에 속할 때
                preD += d;
            }

            else if ((a <= curD && b > curD) || (a > curD && b <= curD)) {
                // curD기준으로 양쪽에 있을 때
                answer = (int) (Math.log((double) d * 2) / Math.log(2));
                break;
            }

            t *= 2;
        }
        return answer;
    }
}
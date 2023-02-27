package org.codingtest.level0.p120843;

class Solution {
    public int solution(int[] numbers, int k) {
        return (((k - 1) * 2) % numbers.length) + 1;
        // (k - 1) * 2: 이동할 횟수
        // (k - 1) * 2 % numbers.length: 이동할 횟수 중에 numbers가 반복되고 위치할 인덱스
        // + 1: 0번 인덱스 - 첫 번째 ...
    }
}
package org.codingtest.level0.p120845;

class Solution {
    public int solution(int[] box, int n) {
        return (box[0] / n) * (box[1] / n) * (box[2] / n);
    }

    public static void main(String[] args) {
        int result = new Solution().solution(new int[]{10, 8, 6}, 3);
        System.out.println("result = " + result);
    }
}
package org.codingtest.level2.p12953;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2, 6, 8, 14}));
    }
    public int solution(int[] arr) {

        int i = 1;

        while (i < 200) {
            boolean isFind = true;
            for (int num : arr) {
                if (i % num != 0) {
                    isFind = false;
                    break;
                }
            }
            if (isFind) {
                return i;
            }
            i++;
        }
        return 0;
    }
}
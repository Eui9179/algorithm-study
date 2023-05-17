package org.codingtest.level2.p12911;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(78));
    }
    public int solution(int n) {
        return getGreaterThanNum(n);
    }

    public int getGreaterThanNum(int num) {
        int n = getOneCount(num);
        int next_num = num + 1;

        while (isEqualZero(n, next_num)) {
            next_num++;
        }
        return next_num;
    }

    public int getOneCount(int num) {
        int count = 0;
        String binaryString = Integer.toBinaryString(num);
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count += 1;
            }
        }
        return count;
    }

    public boolean isEqualZero(int n, int num) {
        return getOneCount(num) != n;
    }
}
package org.codingtest.level2.p77885;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String bNumber = Long.toString(numbers[i], 2);
            int curLen = bNumber.length() - bNumber.replaceAll("0", "").length();
            int k = 1;

            while (true) {
                String bNumber2 = Long.toString(numbers[i] + k, 2);
                int nextLen = bNumber2.length() - bNumber2.replaceAll("0", "").length();
                if (Math.abs(curLen - nextLen) <= 2) {
                    answer[i] = numbers[i] + k;
                    break;
                }
                k++;
            }
        }

        return answer;
    }
}
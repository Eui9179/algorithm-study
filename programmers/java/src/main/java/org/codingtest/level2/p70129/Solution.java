package org.codingtest.level2.p70129;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};

        while (!s.equals("1")) {
            s = convertBinaryString(s, answer);
        }

        return answer;
    }

    public String convertBinaryString(String binaryString, int[] answer) {
        String removed = binaryString.replaceAll("0", "");
        int removedCount = binaryString.length() - removed.length();
        increaseAnswer(answer, removedCount);
        return Integer.toBinaryString(removed.length());
    }

    public void increaseAnswer(int[] answer, int count) {
        answer[0] += 1;
        answer[1] += count;
    }
}
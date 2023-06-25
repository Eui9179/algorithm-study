package org.codingtest.c.test1;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("abbaa"));
        System.out.println(new Solution().solution("ababab"));
        System.out.println(new Solution().solution("aabbcc"));
        System.out.println(new Solution().solution(""));
        System.out.println(new Solution().solution("zxcva"));
        System.out.println(new Solution().solution("zzzzyy"));
    }
    public int solution(String S) {
        if (S.length() == 0) return 0;

        int answer = 0;

        char[] doubleSArr = doubleCharArr(S);
        int length = S.length();
        for (int i = 0; i < length; i++) {
            if (doubleSArr[i] == doubleSArr[i + length - 1]) answer++;
        }

        return answer;
    }

    public char[] doubleCharArr(String S) {
        int length = S.length();
        char[] result = new char[length * 2];
        for (int d = 0; d < 2; d++) {
            for (int i = 0; i < length; i++) {
                result[i + (d * length)] = S.charAt(i);
            }
        }
        return result;
    }
}

package org.codingtest.score_kit.greedy.p42860;

/*
name 	return
"JEROEN" 	56
"JAN" 	23
 */
class Solution {
    private static int answer = 0;

    public static void main(String[] args) {
        System.out.println(new Solution().solution("JZAAAAAZ"));
    }

    public int solution(String name) {
        if ("A".repeat(name.length()).equals(name)) return 0;

        answer += calcEngCount(name.charAt(0));

        int cursor = 0;
        for (int i = 1 ; i < name.length() ; i++) {
            answer += calcEngCount(name.charAt(i));
            cursor = calcMoveCount(name, cursor);
        }

        return answer;
    }

    private int calcMoveCount(String name, int cursor) {

        return 0;
    }

    private int calcEngCount(char c) {
        return Math.min(c - 'A', 'Z' - c + 1);
    }

    private int moveRight(int cursor, int length) {
        cursor++;
        if (cursor >= length) {
            return 0;
        }
        return cursor;
    }

    private int moveLeft(int cursor, int length) {
        cursor--;
        if (cursor < 0) {
            return length -1;
        }
        return cursor;
    }
}

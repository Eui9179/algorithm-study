package org.codingtest.level2.p12951;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("a as    b c d e f g  "));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.split("");

        sb.append(strings[0].toUpperCase());

        for (int i = 1; i < strings.length; i++) {
            if (strings[i].equals(" ")) {
                sb.append(" ");
            } else {
                if (strings[i - 1].equals(" ")) {
                    sb.append(strings[i].toUpperCase());
                } else {
                    sb.append(strings[i].toLowerCase());
                }
            }
        }

        return sb.toString();
    }
}
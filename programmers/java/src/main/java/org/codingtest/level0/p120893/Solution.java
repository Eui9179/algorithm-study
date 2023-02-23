package org.codingtest.level0.p120893;

public class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (Character.isLowerCase(c)) sb.append(String.valueOf(c).toUpperCase());
            else sb.append(String.valueOf(c).toLowerCase());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char A = 'A';
        char a = 'a';

        System.out.println((int) A);
        System.out.println((int) a);
    }
}

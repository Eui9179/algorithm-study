package org.codingtest.level0.p120822;
public class Solution {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("hello"));
    }
}

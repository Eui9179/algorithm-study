package org.codingtest.level0.p120921;

class Solution {
    public int solution(String a, String b) {
        return b.repeat(2).indexOf(a);
    }
    public int solution2(String a, String b) {
        if (a.equals(b)) {
            return 0;
        }
        for (int i = 1; i <= a.length(); i++) {
            a = next(a);
            if (a.equals(b)) {
                return i;
            }
        }
        return -1;
    }

    public static String next(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.insert(0, sb.charAt(sb.length() - 1));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
package org.codingtest.level2.p12909;
class Solution {
    boolean solution(String s) {
        int standard = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') standard += 1;
            else standard -= 1;
            if (standard < 0) return false;
        }
        return standard == 0;
    }
}
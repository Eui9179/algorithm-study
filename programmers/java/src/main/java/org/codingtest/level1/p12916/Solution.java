package org.codingtest.level1.p12916;

class Solution {
    boolean solution(String s) {
        int pCount = s.length() - s.replaceAll("pP", "").length();
        int yCount = s.length() - s.replaceAll("yY", "").length();
        return pCount == yCount;
    }
}

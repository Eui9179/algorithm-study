package org.codingtest.level1.p12917;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new StringBuilder(new String(chars)).reverse().toString();
    }
}

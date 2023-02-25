package org.codingtest.level0.p120886;

import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] beforeCharArr = before.toCharArray();
        char[] afterCharArr = after.toCharArray();

        Arrays.sort(beforeCharArr);
        Arrays.sort(afterCharArr);


        return new String(beforeCharArr).equals(new String(afterCharArr)) ? 1 : 0;
    }
}

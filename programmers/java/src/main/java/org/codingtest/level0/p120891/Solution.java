package org.codingtest.level0.p120891;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int order) {
        String numStr = String.valueOf(order);
        String replacedStr;
        replacedStr = numStr.replaceAll("[369]", "");
//        replacedStr = replacedStr.replace("6", "");
//        replacedStr = replacedStr.replace("9", "");
        return numStr.length() - replacedStr.length();
    }
}
package org.codingtest.level0.p120956;

import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        ArrayList<String> possible = new ArrayList<>(Arrays.asList("aya", "ye", "woo", "ma"));
        for (int i = 0; i< babbling.length; i++) {
            for (String poss : possible) {
                babbling[i] = babbling[i].replace(poss, "0");
            }
        }
        return (int) Arrays.stream(babbling)
                .map(s -> s.replace("0", ""))
                .filter(s -> s.equals(""))
                .count();
    }
}

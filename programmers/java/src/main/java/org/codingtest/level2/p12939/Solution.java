package org.codingtest.level2.p12939;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String str : s.split(" ")) {
            numbers.add(Integer.parseInt(str));
        }

        return Collections.min(numbers) + " " + Collections.max(numbers);
    }
}
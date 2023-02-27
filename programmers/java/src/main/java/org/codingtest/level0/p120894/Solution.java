package org.codingtest.level0.p120894;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(String numbers) {
        ArrayList<String> numStrList = new ArrayList<>(Arrays.asList(
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        ));

        for (String numStr : numStrList) {
            numbers = numbers.replace(
                    numStr, String.valueOf(numStrList.indexOf(numStr))
            );
        }

        return Long.parseLong(numbers);
    }
}
package org.codingtest.level0.p120895;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        List<String> str = Arrays.stream(my_string.split("")).toList();

        Collections.swap(str, num1, num2);
        return String.join("", str);
    }
}
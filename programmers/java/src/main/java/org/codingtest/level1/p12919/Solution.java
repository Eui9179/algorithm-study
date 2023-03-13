package org.codingtest.level1.p12919;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String[] seoul) {
        List<String> seoulList = Arrays.stream(seoul).collect(Collectors.toList());
        return "김서방은" + seoulList.indexOf("Kim") + "에 있다";
    }
}

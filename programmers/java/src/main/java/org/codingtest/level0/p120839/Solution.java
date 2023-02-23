package org.codingtest.level0.p120839;

import java.util.Arrays;

public class Solution {
    public String solution(String rsp) {
        StringBuilder answer = new StringBuilder();
        Arrays.stream(rsp.split(""))
                .forEach(s -> {
                    if (s.equals("2")) answer.append("0");
                    else if (s.equals("0")) answer.append("5");
                    else answer.append("2");
                });
        return answer.toString();
    }
}

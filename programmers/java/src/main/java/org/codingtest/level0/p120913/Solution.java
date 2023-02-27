package org.codingtest.level0.p120913;

import java.util.ArrayList;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> answer = new ArrayList<>();
        int repeat = my_str.length() / n;
        for (int i = 0; i < repeat; i++) {
            answer.add(my_str.substring(i * n, i * n + n));
        }
        if (my_str.length() % n != 0) {
            answer.add(my_str.substring(repeat * n));
        }
        return answer.toArray(String[]::new);
    }
}

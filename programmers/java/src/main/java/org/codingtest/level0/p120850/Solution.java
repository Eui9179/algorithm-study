package org.codingtest.level0.p120850;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(String my_string) {
        String[] newString = my_string.replaceAll("[a-z|A-Z]", "").split("");
        int[] answer = Arrays.stream(newString).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        String my_string = "q1w2e3r4";
        String[] newString = my_string.replaceAll("[a-zA-Z]", "").split("");
//        int[] answer = Arrays.stream(newString).mapToInt(Integer::parseInt).toArray();
//        Arrays.sort(answer);
        System.out.println(Arrays.toString(newString));
    }
}

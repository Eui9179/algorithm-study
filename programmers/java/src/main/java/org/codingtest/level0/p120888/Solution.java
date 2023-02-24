package org.codingtest.level0.p120888;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        return my_string.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
//        List<String> stringList = new ArrayList<>();
//        String[] strings = my_string.split("");
//
//        for (String string : strings) {
//            if (!stringList.contains(string)) {
//                stringList.add(string);
//            }
//        }
//        return String.join("", stringList);
    }

    public static void main(String[] args) {
        String result = new Solution().solution("We are the world");
        System.out.println("result = " + result);
    }
}
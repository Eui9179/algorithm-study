package org.codingtest.level0.p120844;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        List<Integer> answer;
        List<Integer> numberList = Arrays.stream(numbers)
                .boxed()
                .toList();
        if (direction.equals("right")) {
            answer = new ArrayList<>(numberList.subList(0, numbers.length - 1));
            answer.add(0, numberList.get(numbers.length - 1));
        } else {
            answer = new ArrayList<>(numberList.subList(1, numbers.length));
            answer.add(numbers.length - 1, numberList.get(0));
        }
        System.out.println(Arrays.toString(answer.stream().mapToInt(Integer::intValue).toArray()));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 3}, "right");
    }
}
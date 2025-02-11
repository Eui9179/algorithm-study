package org.codingtest.score_kit.sort2.p42746;

/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
입출력 예
numbers	return
[6, 10, 2]	"6210"
[3, 30, 34, 5, 9]	"9534330"
 */

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3, 30, 34}));
        System.out.println(new Solution().solution(new int[]{929, 949}));
        System.out.println(new Solution().solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new Solution().solution(new int[]{101, 10, 232, 23}));
        System.out.println(new Solution().solution(new int[]{1000, 111, 110, 101, 100, 11, 10, 1, 0}));
    }

    public String solution(int[] numbers) {

        if (Arrays.stream(numbers).sum() == 0) return "0";

        String[] numbersStr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(numbersStr, (s1, s2) -> Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2));

        return String.join("", numbersStr);
    }
}
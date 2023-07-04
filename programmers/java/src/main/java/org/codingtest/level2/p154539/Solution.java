package org.codingtest.level2.p154539;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;

        int[] answer = new int[n];

        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (stack.size() == 0) {
                stack.add(i);
                continue;
            }

            while (stack.size() > 0 && numbers[stack.get(stack.size() - 1)] < numbers[i]) {
                Integer index = stack.remove(stack.size() - 1);
                answer[index] = numbers[i];
            }

            stack.add(i);
        }

        for (Integer i: stack) {
            answer[i] = -1;
        }

        return answer;
    }
}

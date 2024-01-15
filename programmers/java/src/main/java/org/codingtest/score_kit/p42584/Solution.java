package org.codingtest.score_kit.p42584;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 문제 설명

 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 제한사항

 prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 prices의 길이는 2 이상 100,000 이하입니다.

 입출력 예
 prices 	return
 [1, 2, 3, 2, 3] 	[4, 3, 1, 1, 0]
 입출력 예 설명

 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().solution(new int[]{1, 2, 3, 2, 3}))
        );
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        List<Node> stack = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.get(stack.size() - 1).value > prices[i]) {
                Node node = stack.remove(stack.size() - 1);
                answer[node.index] = i - node.index;
            }
            stack.add(Node.of(i, prices[i]));
        }

        while (!stack.isEmpty()) {
            Node node = stack.remove(stack.size() - 1);
            answer[node.index] = (prices.length - 1) - node.index;
        }

        return answer;
    }

    public static class Node {
        private final int index;
        private final int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public static Node of(int index, int value) {
            return new Node(index, value);
        }
    }
}

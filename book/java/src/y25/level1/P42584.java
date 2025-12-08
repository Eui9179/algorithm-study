package y25.level1;

import java.util.*;

public class P42584 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P42584().solution(new int[]{1, 2, 3, 2, 3})));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        ArrayDeque<Node> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                Node node = stack.pop();
                answer[node.index] = i - node.index;
            }
            stack.push(new Node(i, prices[i]));
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            answer[node.index] = (prices.length - 1) - node.index;
        }

        return answer;
    }

    private static class Node {
        int index;
        int price;

        public Node(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
}

package y25.sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class P364 {
    public static void main(String[] args) {
        solution(new int[]{10, 20, 40});
    }

    private static void solution(int[] cards) {
        int result = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int card : cards) {
            pq.offer(card);
        }
        while (pq.size() > 1) {
            int one = pq.poll();
            int two = pq.poll();
            int sum = one + two;
            result += sum;
            pq.offer(sum);
        }
        System.out.println("result = " + result);
    }
}

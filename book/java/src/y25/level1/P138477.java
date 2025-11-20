package y25.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P138477 {
    public static void main(String[] args) {

    }

    public static int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k && i < score.length; i++) {
            pq.offer(score[i]);
            answer.add(pq.peek());
        }

        for (int i = k; i < score.length; i++) {
            int last = pq.peek();
            if (last < score[i]) {
                pq.poll();
                pq.offer(score[i]);
            }
            answer.add(pq.peek());
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}

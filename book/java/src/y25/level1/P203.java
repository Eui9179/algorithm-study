package y25.level1;

import java.util.LinkedList;
import java.util.Queue;

public class P203 {
    public static void main(String[] args) {
        System.out.println(new P203().solution(5, 2));
    }

    public int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            int i = 0;
            while (i < k) {
                queue.offer(queue.poll());
                i++;
            }
            queue.poll();
        }
        return queue.poll();
    }
}

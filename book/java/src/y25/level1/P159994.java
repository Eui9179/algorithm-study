package y25.level1;

import java.util.LinkedList;
import java.util.Queue;

public class P159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        for (String c1 : cards1) {
            queue1.offer(c1);
        }

        for (String c2 : cards2) {
            queue2.offer(c2);
        }
        //양 큐 하나씩 확인
        for (String g: goal) {
            if (!queue1.isEmpty() && queue1.peek().equals(g)) {
                queue1.poll();
            } else if (!queue2.isEmpty() && queue2.peek().equals(g)) {
                queue2.poll();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}

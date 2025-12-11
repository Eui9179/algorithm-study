package y25.level1;

import java.util.*;

public class P42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<int[]> queue = new LinkedList<>(); // [index, progress]
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new int[]{i, progresses[i]});
        }

        int dayCount = 0;
        int processCount = 0;

        while (!queue.isEmpty()) {
            boolean isProcessed = false;
            queue.peek()[1] += speeds[queue.peek()[0]];
            dayCount++;

            while (!queue.isEmpty() && queue.peek()[1] >= 100) {
                isProcessed = true;
                queue.poll();
                processCount++;

                if (!queue.isEmpty()) {
                    queue.peek()[1] += speeds[queue.peek()[0]] * dayCount;
                }
            }

            if (isProcessed) {
                answer.add(processCount);
                processCount = 0;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}

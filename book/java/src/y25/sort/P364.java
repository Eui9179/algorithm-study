package y25.sort;

import java.util.*;

public class P364 {
    public static void main(String[] args) {
        solution(5, new ArrayList<>(List.of(2, 1, 2, 6, 2, 4, 3, 3)));

    }

    private static void solution(int n, List<Integer> stages) {
        Queue<Stage> pq = new PriorityQueue<>((s1, s2) -> s2.failRatio - s1.failRatio);
        Collections.sort(stages);

        int current = stages.get(0);
        int count = 0;

        for (int i = 0; i < stages.size(); i++) {
            if (current != stages.get(i)) {
                double failRatio = (double) count / (stages.size() - (i - count));
                pq.offer(new Stage(stages.get(i - count), failRatio));
                current = stages.get(i);
                count = 1;
            } else {
                count++;
            }
        }

        while (!pq.isEmpty()) {
            Stage stage = pq.poll();
            System.out.println(stage.stage);
        }
    }

    private static class Stage {
        int stage;
        int failRatio;

        public Stage(int stage, double failRatio) {
            this.stage = stage;
            this.failRatio = (int) (failRatio * 1000);
        }
    }
}

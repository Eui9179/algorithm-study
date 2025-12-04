package y25.level1;

import java.util.*;

public class P126 {
    public static void main(String[] args) {
    }

    public int[] solution(int n, int[] stages) {
        // 실패율 = 스테이지 머물고 있는 사람 / 도전한 사람
        // n = 7
        // 1 2 2 2 3 3 4 6
        // 5 7
        // 1 -> 8
        // 2 -> 7
        // 3 -> 4

        // 큐    [6]
        // 대기   [6]
        // 1은 (1 빼고 나머지) /(큐 + 대기) 도전한 사람
        // 1 전부 pop

        // 2는
        List<Integer> answer = new ArrayList<>();
        List<StageFailRate> failRates = new ArrayList<>();

        Arrays.sort(stages);

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();

        for (int stage : stages) {
            wait.offer(stage);
        }

        while (!wait.isEmpty()) {
            if (!queue.isEmpty() && queue.peek() < wait.peek()) { // 이전 스테이지 전부 집계
                int currentStage = queue.peek();
                int total = queue.size() + wait.size();
                int failCount = queue.size();
                queue.clear();
                failRates.add(new StageFailRate(currentStage, ((double) failCount / total)));
            } else {
                queue.offer(wait.poll());
            }
        }

        int failCount = 0;
        int total = queue.size();
        int stage = queue.peek();

        if (!queue.isEmpty() && queue.peek() <= n) {
            while (!queue.isEmpty() && queue.peek() <= n) {
                failCount++;
                queue.poll();
            }
            failRates.add(new StageFailRate(stage, (double) failCount / total));
        }

        Collections.sort(failRates);

        for (StageFailRate failRate : failRates) {
            answer.add(failRate.stage);
        }

        for (int i = 1; i <= n; i++) {
            if (!answer.contains(i)) {
                answer.add(i);
            }
        }
        System.out.println("answer = " + answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static class StageFailRate implements Comparable<StageFailRate> {
        int stage;
        double failRate;

        StageFailRate(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(StageFailRate s) {
            return Double.compare(s.failRate, this.failRate) == 0 ?
                    this.stage - s.stage :
                    Double.compare(s.failRate, this.failRate);
        }

        @Override
        public String toString() {
            return "StageFailRate{" +
                    "stage=" + stage +
                    ", failRate=" + failRate +
                    '}';
        }
    }
}

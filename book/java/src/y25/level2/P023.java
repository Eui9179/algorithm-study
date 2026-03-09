package y25.level2;

import java.util.*;

public class P023 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{
                {1, 2},
                {2, 5},
                {5, 1},
                {3, 4},
                {4, 6}
        }));

        System.out.println(solution(6, new int[][]{
                {1, 2},
                {2, 5},
                {5, 1},
                {3, 4},
                {4, 6},
                {5, 4},
                {2, 4},
                {2, 3}
        }));
    }

    public static int solution(int n, int[][] graph) {
        int answer = 0;
        Map<Integer, List<Integer>> graphMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graphMap.put(i, new ArrayList<>());
        }

        for (int[] g: graph) {
            graphMap.get(g[0]).add(g[1]);
        }

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            answer++;

            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(i);

            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                visited[pop] = true;
                for (Integer next: graphMap.get(pop)) {
                    if (visited[next]) continue;
                    stack.push(next);
                }
            }
        }

        return answer;
    }
}

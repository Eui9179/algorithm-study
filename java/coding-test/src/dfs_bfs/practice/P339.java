package dfs_bfs.practice;
import java.util.*;
public class P339 {
    public static void solution(int n, int x, int k, ArrayList<Integer>[] graph) {
        ArrayList<Integer> q = new ArrayList<>();
        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int node, currentK = 0;
        boolean isExist = false;

        q.add(x);

        Arrays.fill(distances, -1);

        distances[x] = 0;

        while (q.size() > 0) {
            node = q.remove(0);
            if (visited[node]) continue;
            visited[node] = true;

            for (Integer nextNode : graph[node]) {
                if (distances[nextNode] == -1) {
                    currentK = distances[node] + 1;
                    distances[nextNode] = currentK;
                }
                q.add(nextNode);
            }
            if (currentK > k) {
                break;
            }
        }

        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == k) {
                System.out.println(i);
                isExist = true;
            }
        }
        if (!isExist) {
            System.out.println(-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 도시 개수
        int m = sc.nextInt(); // 도로 개수
        int k = sc.nextInt(); // 목표 거리
        int x = sc.nextInt(); // 출발 도시
        int a, b; // a -> b

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            graph[a].add(b);
        }
        solution(n, x, k, graph);
    }
}

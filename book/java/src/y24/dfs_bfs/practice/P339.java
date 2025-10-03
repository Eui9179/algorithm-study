package y24.dfs_bfs.practice;
import java.util.*;
public class P339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int node;
        int cycle = 0, cycleCount = 1;

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        Map<Integer, ArrayList<Integer>> nodeInCycle = new HashMap<>();

        ArrayList<Integer> q = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];


        for (int i = 0; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < k + 1; i++) {
            nodeInCycle.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        q.add(x);

        while (q.size() > 0) {

            node = q.remove(0);
            cycleCount--;

            if (!visited[node]) {
                visited[node] = true;
                q.addAll(graph.get(node));
                nodeInCycle.get(cycle).add(node);
            }

            if (cycleCount == 0) {
                cycle++;
                cycleCount = q.size();
            }

            if (cycle > k) {
                break;
            }
        }

        if (nodeInCycle.get(k).size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(nodeInCycle.get(k));
            for (int nic: nodeInCycle.get(k)) {
                System.out.println(nic);
            }
        }
    }
//    public static void solution(int n, int x, int k, ArrayList<Integer>[] graph) {
//        ArrayList<Integer> q = new ArrayList<>();
//        int[] distances = new int[n + 1];
//        boolean[] visited = new boolean[n + 1];
//        int node, currentK = 0;
//        boolean isExist = false;
//
//        q.add(x);
//
//        Arrays.fill(distances, -1);
//
//        distances[x] = 0;
//
//        while (q.size() > 0) {
//            node = q.remove(0);
//            if (visited[node]) continue;
//            visited[node] = true;
//
//            for (Integer nextNode : graph[node]) {
//                if (distances[nextNode] == -1) {
//                    currentK = distances[node] + 1;
//                    distances[nextNode] = currentK;
//                }
//                q.add(nextNode);
//            }
//            if (currentK > k) {
//                break;
//            }
//        }
//
//        for (int i = 0; i < distances.length; i++) {
//            if (distances[i] == k) {
//                System.out.println(i);
//                isExist = true;
//            }
//        }
//        if (!isExist) {
//            System.out.println(-1);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // 도시 개수
//        int m = sc.nextInt(); // 도로 개수
//        int k = sc.nextInt(); // 목표 거리
//        int x = sc.nextInt(); // 출발 도시
//        int a, b; // a -> b
//
//        ArrayList<Integer>[] graph = new ArrayList[n + 1];
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < m; i++) {
//            a = sc.nextInt();
//            b = sc.nextInt();
//            graph[a].add(b);
//        }
//        solution(n, x, k, graph);
//    }
}

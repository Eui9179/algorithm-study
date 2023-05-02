package dfs_bfs;

import java.util.*;

public class BFS {
    public static Map<String, List<String>> genMap() {
        return Map.of(
                "A", List.of("B", "C"),
                "B", List.of("D", "E"),
                "C", List.of("F", "G"),
                "D", List.of(),
                "E", List.of(),
                "F", List.of(),
                "G", List.of()
        );
    }

    public static void bfsFunc(Map<String, List<String>> graph, String startVertex) {
        ArrayList<String> stack = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();

        stack.add(startVertex);

        while (stack.size() > 0) {
            String vertex = stack.remove(0);

            if (!visited.contains(vertex)) {
                visited.add(vertex);
                stack.addAll(graph.get(vertex));
            }
        }
        System.out.println("visited = " + visited);
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = genMap();
        bfsFunc(graph, "A");
    }
}

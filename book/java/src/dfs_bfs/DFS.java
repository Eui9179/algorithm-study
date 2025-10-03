package dfs_bfs;

import java.util.*;

public class DFS {
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

    public static void dfsFunc(Map<String, List<String>> graph,
                               String startNode) {
        ArrayList<String> stack = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();

        stack.add(startNode);

        while (stack.size() > 0) {
            String vert = stack.remove(0);
            if (!visited.contains(vert)) {
                visited.add(vert);
                stack.addAll(0, graph.get(vert));
            }
        }
        System.out.println("visited = " + visited);
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = genMap();
        dfsFunc(graph, "A");
    }
}

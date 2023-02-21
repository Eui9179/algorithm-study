package dfs_bfs;

import java.util.*;

public class BFS {
    public static void bfsFunc(Map<String, ArrayList<String>> graph, String startVertex) {
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
        Map<String, ArrayList<String>> graph = new HashMap<>();
        initMap(graph);

        bfsFunc(graph, "A");
    }

    public static void initMap(Map<String, ArrayList<String>> graph) {
        graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>(Arrays.asList("D")));
        graph.put("G", new ArrayList<>(Arrays.asList("C")));
        graph.put("H", new ArrayList<>(Arrays.asList("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<>(Arrays.asList("I")));
    }
}

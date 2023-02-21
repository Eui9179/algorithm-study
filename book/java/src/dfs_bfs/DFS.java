package dfs_bfs;

import java.util.*;

public class DFS {
    public static void dfsFunc(Map<String, ArrayList<String>> graph, String startVertex) {
        ArrayList<String> stack = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();

        stack.add(startVertex);

        while (stack.size() > 0) {
            String vert = stack.remove(stack.size() - 1);
            if (!visited.contains(vert)) {
                visited.add(vert);
                stack.addAll(graph.get(vert));
            }
        }
        System.out.println("visited = " + visited);
    }
    public static void main(String[] args) {
        Map<String, ArrayList<String>> graph = new HashMap<>();
        initMap(graph);

        dfsFunc(graph, "A");
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

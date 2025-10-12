package y25.dijkstra;

import java.util.*;

public class DijkstraExample {
    public static void main(String[] args) {
        dijkstra(new int[][]{
                {1, 2, 2},
                {1, 3, 5},
                {1, 4, 1},
                {2, 3, 3},
                {2, 4, 2},
                {3, 2, 3},
                {3, 6, 5},
                {4, 3, 3},
                {4, 5, 1},
                {5, 3, 1},
                {5, 6, 2}
        }, 1);
    }

    private static void dijkstra(int[][] graph, int start) {
        Map<Integer, List<Node>> nodeMap = new HashMap<>();
        initNodeMap(nodeMap, graph);

        int[] result = new int[nodeMap.size() + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (result[node.index] < node.distance) continue;

            for (Node nextNode : nodeMap.get(node.index)) {
                int cost = result[node.index] + nextNode.distance;
                if (cost < result[nextNode.index]) {
                    result[nextNode.index] = cost;
                    pq.offer(nextNode);
                }
            }
        }

        for (int index : nodeMap.keySet()) {
            System.out.println(index + " = " + result[index]);
        }
    }

    private static void example(int[][] graph, int start) {
        Map<Integer, List<Node>> nodeMap = new HashMap<>();
        initNodeMap(nodeMap, graph);

        int[] distances = new int[nodeMap.size() + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (distances[currentNode.index] < currentNode.distance) continue;

            for (Node nextNode : nodeMap.get(currentNode.index)) {
                int cost = distances[currentNode.index] + nextNode.distance;
                if (cost < distances[nextNode.index]) {
                    distances[nextNode.index] = cost;
                    queue.offer(nextNode);
                }
            }
        }

    }

    private static void initNodeMap(Map<Integer, List<Node>> nodeMap, int[][] graph) {
        for (int[] g : graph) {
            int startNode = g[0];
            int targetNode = g[1];
            int distance = g[2];

            if (!nodeMap.containsKey(startNode)) {
                nodeMap.put(startNode, new ArrayList<>());
            }

            if (!nodeMap.containsKey(targetNode)) {
                nodeMap.put(targetNode, new ArrayList<>());
            }

            nodeMap.get(startNode).add(new Node(targetNode, distance));
        }
    }

    private static class Node implements Comparable<Node> {
        private final int index;
        private final int distance;

        private Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", distance=" + distance +
                    '}';
        }
    }
}

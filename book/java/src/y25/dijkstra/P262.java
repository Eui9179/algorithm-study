package y25.dijkstra;

import java.util.*;

public class P262 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                3,
                2,
                1,
                new int[][]{{1, 2, 4}, {1, 3, 2}}))
        );
    }

    private static int[] solution(int n, int m, int start, int[][] graph) {
        Map<Integer, List<City>> cityGraph = new HashMap<>();
        for (int[] g : graph) {
            int s = g[0];
            int t = g[1];
            int d = g[2];

            if (!cityGraph.containsKey(s)) {
                cityGraph.put(s, new ArrayList<>());
            }

            if (!cityGraph.containsKey(t)) {
                cityGraph.put(t, new ArrayList<>());
            }

            cityGraph.get(s).add(new City(t, d));
        }

        int[] result = new int[cityGraph.size() + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;

        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            City currentCity = pq.poll();

            if (result[currentCity.index] < currentCity.distance) continue;

            for (City connect : cityGraph.get(currentCity.index)) {
                int cost = connect.distance + result[currentCity.index];
                if (cost < result[connect.index]) {
                    result[connect.index] = cost;
                    pq.offer(connect);
                }
            }
        }

        return result;

    }

    private static class City implements Comparable<City> {

        int index;
        int distance;

        City(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(City city) {
            return this.distance - city.distance;
        }
    }
}

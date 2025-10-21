package y25.dfsbfs;

import java.util.*;

public class P340 {
    public static void main(String[] args) {
        solution(4, 2, 1, new int[][]{
                {1, 2},
                {1, 3},
                {2, 3},
                {2, 4}
        });
        solution(4, 2, 1, new int[][]{
                {1, 2},
                {1, 3},
                {1, 4}
        });
        solution(4, 1, 1, new int[][]{
                {1, 2},
                {1, 3},
                {2, 3},
                {2, 4}
        });

    }

    private static void solution(int cities, int k, int start, int[][] graph) {
        // graph map 형태로 변경
        Map<Integer, List<City>> graphMap = new HashMap<>();
        for (int i = 1; i <= cities; i++) {
            graphMap.put(i, new ArrayList<>());
        }

        for (int[] g : graph) {
            graphMap.get(g[0]).add(new City(g[1], 1));
        }

        // 거리 테이블 초기화
        // 내 자신 거리는 0
        int[] distances = new int[cities + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        // 우선순위 큐 초기화
        // 내 자신의 거리는 0
        Queue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            // 현재 노드
            City currentCity = pq.poll();

            // 테이블의 거리가 현재 거리보다 작으면 계산할 필요 없음
            if (distances[currentCity.index] < currentCity.distance) {
                continue;
            }

            // 연결된 노드 검사
            for (City city : graphMap.get(currentCity.index)) {
                // 현재 노드까지의 거리 + 도착 노드 거리
                int cost = distances[currentCity.index] + city.distance;
                // cost < 최근에 계산된 출발 노드 ~ 도착노드 거리
                if (cost < distances[city.index]) {
                    // 거리 갱신
                    distances[city.index] = cost;
                    pq.offer(city);
                }
            }
        }
        System.out.println(Arrays.toString(distances));

        boolean isExist = false;
        for (int i = 1; i < distances.length; i++) {
            if (distances[i] == k) {
                System.out.println(i);
                isExist = true;
            }
        }

        if (!isExist) System.out.println(-1);
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
            if (this.distance == city.distance) {
                return this.index - city.distance;
            }
            return this.distance - city.distance;
        }
    }

}

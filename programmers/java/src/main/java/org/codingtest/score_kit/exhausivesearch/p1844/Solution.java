package org.codingtest.score_kit.exhausivesearch.p1844;

/*

지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다.
다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.

움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동
맵을 벗어난 길은 갈 수 없습니다.


도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return
도착할 수 없을 때는 -1

n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
0은 벽이 있는 자리, 1은 벽이 없는 자리

[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
 */

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(new Solution().solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

    public int solution(int[][] maps) {
        // 한 턴마다 이동할 수 있는 곳에 턴 수 입력

        int[][] routes = initRoutes(maps);
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[] position = new int[]{0, 0};

        List<int[]> queue = new ArrayList<>();
        queue.add(position);

        while (!queue.isEmpty()) {
            int[] current = queue.remove(0);
            for (int[] direction : directions) {
                int nextI = current[0] + direction[0];
                int nextJ = current[1] + direction[1];
                if (nextI >= 0 && nextI < maps.length && nextJ >= 0 && nextJ < maps[0].length
                        && maps[nextI][nextJ] != 0 && routes[nextI][nextJ] == -1) {
                    queue.add(new int[]{nextI, nextJ});
                    routes[nextI][nextJ] = routes[current[0]][current[1]] + 1;
                }
            }
        }

        return routes[routes.length - 1][routes[0].length - 1];
    }

    private int[][] initRoutes(int[][] maps) {
        int[][] routes = new int[maps.length][maps[0].length];
        for (int[] route : routes) {
            Arrays.fill(route, -1);
        }
        routes[0][0] = 1;
        return routes;
    }
}

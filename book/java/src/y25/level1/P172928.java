package y25.level1;

import java.util.*;

public class P172928 {

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0 ,0};
        Map<String, int[]> directionMap = new HashMap<>();
        directionMap.put("E", new int[]{0, 1});
        directionMap.put("W", new int[]{0, -1});
        directionMap.put("S", new int[]{1, 0});
        directionMap.put("N", new int[]{-1, 0});

        String[][] map = new String[park.length][];

        for (int i = 0; i < map.length; i++) {
            String[] path = park[i].split("");
            map[i] = path;
            for (int j = 0; j < path.length; j++) {
                if (path[j].equals("S")) answer = new int[]{i, j};
            }
        }

        for (String route: routes) {
            String[] split = route.split(" ");
            int[] direction = directionMap.get(split[0]);
            int move = Integer.parseInt(split[1]);

            int nextX = answer[0];
            int nextY = answer[1];
            boolean avaliable = true;

            for (int i = 0; i < move; i++) {
                nextX += direction[0];
                nextY += direction[1];

                if (nextX < 0 || nextY < 0 ||
                        nextX >= map.length || nextY >= map[0].length) {
                    avaliable = false;
                    break;
                }

                if (map[nextX][nextY].equals("X")) {
                    avaliable = false;
                    break;
                }
            }
            if (avaliable) {
                answer[0] = nextX;
                answer[1] = nextY;
            }
        }

        return answer;
    }
}

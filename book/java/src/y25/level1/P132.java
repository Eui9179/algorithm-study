package y25.level1;

import java.util.*;

public class P132 {
    public static void main(String[] args) {
        new P132().solution("ULURRDLLU");
    }
    public int solution(String dirs) {
        int answer = 0;
        int[] position = new int[]{5, 5};

        Map<String, int[]> directions = Map.of(
                "U", new int[]{-1, 0},
                "D", new int[]{1, 0},
                "R", new int[]{0, 1},
                "L", new int[]{0, -1}
        );

        Set<String> visited = new LinkedHashSet<>();

        for (String dir : dirs.split("")) {
            int[] command = directions.get(dir);

            int x = position[0] + command[0];
            int y = position[1] + command[1];

            if (x < 0 || y < 0 || x >= 11 || y >= 11) {
                continue;
            }

            String key1 = position[0] + "," + position[1] + "-" + x + "," + y;
            String key2 =  x + "," + y + "-" + position[0] + "," + position[1];

            if (!visited.contains(key1) && !visited.contains(key2)) {
                visited.add(key1);
                visited.add(key2);
                answer++;
            }

            position[0] = x;
            position[1] = y;
        }

        return answer;
    }
}

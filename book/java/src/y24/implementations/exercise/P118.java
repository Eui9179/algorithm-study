package y24.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P118 {
    static private Map<Integer, ArrayList<Integer>> table = new HashMap<>();

    static {
        table.put(0, new ArrayList<>(Arrays.asList(-1, 0)));
        table.put(1, new ArrayList<>(Arrays.asList(0, -1)));
        table.put(2, new ArrayList<>(Arrays.asList(1, 0)));
        table.put(3, new ArrayList<>(Arrays.asList(0, 1)));
    }

    public static void main(String[] args) {
        int[] current = {1, 1, 0};
        int n = 4;
        int m = 4;
        int[][] map = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1}
        };
        solution(current, map, n, m);
    }

    private static void solution(int[] current, int[][] map, int n, int m) {
        int answer = 1;
        int rotationCount = 0;
        int a = current[0];
        int b = current[1];
        int direc = current[2];

        map[a][b] = 2;

        while (true) {
            if (direc == 4) {
                direc = 0;
            }
            ArrayList<Integer> directions = getDirection(direc);

            int nextA = a + directions.get(0);
            int nextB = b + directions.get(1);

            if (rotationCount == 4) {
                rotationCount = 0;
                nextA = a + directions.get(0);
                nextB = b + directions.get(1);

                if (validate(n, m, nextA, nextB)) {
                    break;
                } else if (map[nextA][nextB] == 1) {
                    break;
                } else {
                    a = nextA;
                    b = nextB;
                }
            } else if (validate(n, m, nextA, nextB)) {
                rotationCount++;
                direc++;
            } else if (map[nextA][nextB] != 0) {
                rotationCount++;
                direc++;
            } else {
                rotationCount = 0;
                a = nextA;
                b = nextB;
                map[a][b] = 2;
                answer++;
            }
        }
        System.out.println("answer = " + answer);
    }

    private static boolean validate(int n, int m, int nextA, int nextB) {
        return nextA < 0 || nextA >= n || nextB < 0 || nextB >= m;
    }

    private static ArrayList<Integer> getDirection(int direction) {
        return table.get(direction);
    }
}

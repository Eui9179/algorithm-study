package dfs_bfs.excercise;

import java.util.ArrayList;
import java.util.Arrays;

public class P149 {
    private static ArrayList<Integer>[] map = new ArrayList[4];

    static {
        map[0] = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 0));
        map[1] = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1));
        map[2] = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        map[3] = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    }

    public static void main(String[] args) {
        int result = solution(map);
        System.out.println("result = " + result);
    }

    private static int solution(ArrayList[] map) {
        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].size(); j++) {
                if (map[i].get(j).equals(0)) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
        return answer;

    }

    private static void dfs(int i, int j) {
        if ((i >= 0) && (i < map.length) && (j >= 0) && (j < map[0].size()) && (map[i].get(j).equals(0))) {
            map[i].set(j, 1);
            dfs(i + 1, j);
            dfs(i - 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);

        }

    }
}

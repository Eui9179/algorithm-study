package y24.implementations.exercise;

import java.util.HashMap;
import java.util.Map;

public class p115 {

    private static Map<String, Integer> table = new HashMap<>();
    static {
        table.put("a", 1);
        table.put("b", 2);
        table.put("c", 3);
        table.put("d", 4);
        table.put("e", 5);
        table.put("f", 6);
        table.put("g", 7);
    }

    public static void main(String[] args) {
        solution("d4");
    }
    private static void solution(String location) {
        int answer = 0;
        int x = getNumber(location.substring(0, 1));
        int y = Integer.parseInt(location.substring(1, 2));

        int[][] steps = {
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                {2, 1}, {1, 2}, {-1, -2}, {-2, 1}
        };

        for (int[] step : steps) {
            int next_row = x + step[0];
            int next_col = y + step[1];

            if (next_row > 0 && next_row < 9 && next_col > 0 && next_col < 9) {
                answer++;
            }
        }
        System.out.println("answer = " + answer);
    }

    private static int getNumber(String eng) {
        return table.get(eng);
    }
}

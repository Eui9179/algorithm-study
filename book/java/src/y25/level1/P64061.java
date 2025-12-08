package y25.level1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P64061 {
    public static void main(String[] args) {
        new P64061().solution(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        }, new int[]{1, 5, 3, 5, 1, 2, 1, 4});
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Deque<Integer> bucket = new ArrayDeque<>();
        List<Deque<Integer>> dolls = new ArrayList<>();

        for (int i = 0; i < board[0].length; i++) {
            dolls.add(new ArrayDeque<>());
        }
        for (int[] line : board) {
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 0) continue;
                dolls.get(j).add(line[j]);
            }
        }

        for (int move : moves) {
            Deque<Integer> queue = dolls.get(move - 1);
            if (queue.isEmpty()) continue;

            int doll = queue.poll();

            if (!bucket.isEmpty() && bucket.peek() == doll) {
                bucket.pop();
                answer += 2;
            } else {
                bucket.push(doll);
            }
        }

        return answer;
    }
}

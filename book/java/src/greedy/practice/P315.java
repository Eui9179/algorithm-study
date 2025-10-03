package greedy.practice;

import java.util.ArrayList;

public class P315 {
    public static int solution(int n, ArrayList<Integer>balls) {
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if (!balls.get(i).equals(balls.get(j))) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
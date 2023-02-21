package greedy.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class P315 {
    public static int solution(int n, int m, ArrayList<Integer>balls) {
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if (!balls.get(i).equals(balls.get(j))) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> balls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            balls.add(weight);
        }
        solution(n, m, balls);
    }

}
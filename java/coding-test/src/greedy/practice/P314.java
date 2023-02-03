package greedy.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 1 1 2 3 9
//
public class P314 {
    public static int solution(ArrayList<Integer> coins) {
        Collections.sort(coins, Comparator.reverseOrder());
        int answer = 1;
        while (calc(answer, coins)) {
            answer++;
        }
        return answer;
    }
    public static boolean calc(int num, ArrayList<Integer> coins) {
        for (int coin : coins) {
            if (num < coin) continue;
            num -= coin;
            if (num < 0) return false;
            else if (num == 0) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> coins = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int coin = sc.nextInt();
            coins.add(coin);
        }
        System.out.println(solution(coins));
    }
}

package dscode;

import java.util.*;

public class P3 {

    static class Attack {
        int expire; // 공격 효과가 끝나는 인덱스
        int power;  // 공격 강도 (높이 감소 횟수)

        Attack(int expire, int power) {
            this.expire = expire;
            this.power = power;
        }
    }

    public static int solution(int D, int[] cakes) {
        int n = cakes.length;
        int turns = 0;
        int active = 0;                 // 현재까지 누적된 공격량
        Queue<Attack> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 1. 만료된 공격 제거
            while (!q.isEmpty() && q.peek().expire < i)
                active -= q.poll().power;

            // 2. 현재 케이크가 아직 남아 있다면 공격 실시
            int remain = cakes[i] - active;
            if (remain > 0) {
                turns += remain;
                active += remain;
                q.offer(new Attack(i + D - 1, remain));
            }

            // 3. 막힘 조건 처리: 다음 케이크가 같거나 높으면 무시
            if (i < n - 1 && cakes[i + 1] >= cakes[i]) continue;
        }

        // 4. 모든 케이크가 0이 되었는지 확인
        for (int c : cakes)
            if (c > 0) return -1;

        return turns;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, new int[]{1, 2, 2})); // 3
    }
}

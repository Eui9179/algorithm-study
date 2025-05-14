package org.codingtest.level1.p250137;

/**
 *
 t 초동안 붕대
 1초마다 x 만큼 회복
 연속 y 만큼 추가 회복
 공격당하면 끊김, 취소나 기술이 끊나면 다시 사용하고 연속은 0으로 초기화
 피해당한 만큼 체력 줆, 죽으면 체력 회복 안 됨

 bandage는 [시전 시간, 초당 회복량, 추가 회복량] 형태의 길이가 3인 정수 배열입니다.
 1 ≤ 시전 시간 = t ≤ 50
 1 ≤ 초당 회복량 = x ≤ 100
 1 ≤ 추가 회복량 = y ≤ 100
 1 ≤ health ≤ 1,000
 1 ≤ attacks의 길이 ≤ 100
 attacks[i]는 [공격 시간, 피해량] 형태의 길이가 2인 정수 배열입니다.
 attacks는 공격 시간을 기준으로 오름차순 정렬된 상태입니다.
 attacks의 공격 시간은 모두 다릅니다.
 1 ≤ 공격 시간 ≤ 1,000
 1 ≤ 피해량 ≤ 100

 시간 	현재 체력(변화량) 	연속 성공 	공격 	설명
 0 	30 	0 	X 	초기 상태
 1 	30(+0) 	1 	X 	최대 체력 이상의 체력을 가질 수 없습니다.
 2 	20(-10) 	0 	O 	몬스터의 공격으로 연속 성공이 초기화됩니다.
 3 	21(+1) 	1 	X
 4 	22(+1) 	2 	X
 5 	23(+1) 	3 	X
 6 	24(+1) 	4 	X
 7 	30(+6) 	5 → 0 	X 	5초 연속 성공해 체력을 5만큼 추가 회복하고 연속 성공이 초기화됩니다.
 8 	30(+0) 	1 	X 	최대 체력 이상의 체력을 가질 수 없습니다.
 9 	15(-15) 	0 	O 	몬스터의 공격으로 연속 성공이 초기화됩니다.
 10 	10(-5) 	0 	O 	몬스터의 공격으로 연속 성공이 초기화됩니다.
 11 	5(-5) 	0 	O 	몬스터의 마지막 공격입니다.
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int current = 0;
        int currentHealth = health;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];

        for (int[] attack : attacks) {
            if (currentHealth < health) {
                int tTime = attack[0] - 1 - current; // 공격시간 직전까지 회복한 시간
                currentHealth += (tTime) * x;
                if (tTime >= t) {
                    currentHealth += y * (tTime / t); // 연속회복 시간 계산
                }
                if (currentHealth > health) {
                    currentHealth = health;
                }
            }

            currentHealth -= attack[1];
            if (currentHealth <= 0) return -1;

            current = attack[0];
        }

        return currentHealth <= 0 ? -1 : currentHealth;
    }
}

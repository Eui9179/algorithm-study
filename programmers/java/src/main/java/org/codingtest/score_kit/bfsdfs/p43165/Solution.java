package org.codingtest.score_kit.bfsdfs.p43165;

/*
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2
+4+1-2+1 = 4
+4-1+2-1 = 4
 */

class Solution {
    private static int answer = 0;

//    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3));
//        System.out.println(new Solution().solution(new int[]{4, 1, 2, 1}, 4));
////        new Solution().test(new ArrayList<>(), 0);
//
//    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int current, int depth) {
        if (depth == numbers.length) {
            if (target == current) answer++;
            return;
        }

        current += numbers[depth];
        dfs(numbers, target, current, depth + 1);
        current -= numbers[depth];

        current -= numbers[depth];
        dfs(numbers, target, current, depth + 1);
    }
}

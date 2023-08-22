package org.codingtest.inflearn.implement.p7;

import java.util.*;

class Solution {
    public int solution(int[] keypad, String password) {
        int[][] keypad2 = generateKeypad(keypad);
        return inputPassword(keypad2, password);
    }

    private int inputPassword(int[][] keypad, String password) {
        int result = 0;
        Map<Integer, int[]> pointMap = initPointMap(keypad);

        for (int i = 0; i < password.length() - 1; i++) {
            int start = Integer.parseInt(String.valueOf(password.charAt(i)));
            int target = Integer.parseInt(String.valueOf(password.charAt(i + 1)));

            result += calcDistance(keypad, pointMap, start, target);
        }

        return result;
    }

    private Map<Integer, int[]> initPointMap(int[][] keypad) {
        Map<Integer, int[]> pointMap = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pointMap.put(keypad[i][j], new int[]{i, j});
            }
        }

        return pointMap;
    }

    private int calcDistance(int[][] keypad, Map<Integer, int[]> pointMap, int start, int target) {
        if (start == target) return 0;

        int[][] steps = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int[] startPoint = pointMap.get(start);

        for (int[] step : steps) {
            int nextI = step[0] + startPoint[0];
            int nextJ = step[1] + startPoint[1];

            if (nextI < 0 || nextJ < 0 || nextI >= 3 || nextJ >= 3) continue;

            if (keypad[nextI][nextJ] == target) {
                return 1;
            }
        }

        return 2;
    }

    private int[][] generateKeypad(int[] keypad) {
        int[][] keypad2 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            keypad2[i] = Arrays.copyOfRange(keypad, i * 3, (i * 3) + 3);
        }
        return keypad2;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
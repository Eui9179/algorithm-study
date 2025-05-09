package org.codingtest.level1.p340198;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{5, 3, 2}, new String[][]{{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}}));
    }

    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        for (int mat : mats) {
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[i].length; j++) {
                    boolean ok = true;
                    for (int k = 0; k < mat; k++) {
                        for (int n = 0; n < mat; n++) {
                            if (i + k >= park.length || j + n >= park[i].length || !park[i + k][j + n].equals("-1")) {
                                ok = false;
                                break;
                            }
                        }
                        if (!ok) break;
                    }
                    if (ok) {
                        answer = Math.max(answer, mat);
                    }
                }
            }
        }
        return answer;
    }
}
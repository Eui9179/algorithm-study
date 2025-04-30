package org.codingtest.level1.p389478;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(22, 6, 8));
    }

    public int solution(int n, int w, int num) {
        int answer = 0;
        int height = n % w == 0 ? n / w : (n / w) + 1;
        int rowIndex = 0;
        boolean flag = false;
        int[][] boxes = new int[height][w];

        for (int i = 0; i < n; i++) {
            int h = i / w;
            if (h % 2 == 0) {
                boxes[h][i % w] = i + 1;
            } else {
                boxes[h][(w - 1) - i % w] = i + 1;
            }
        }

        for (int[] box : boxes) {
            if (flag && box[rowIndex] != 0) {
                answer++;
                continue;
            }

            for (int j = 0; j < box.length; j++) {
                if (box[j] != num) continue;
                flag = true;
                rowIndex = j;
                break;
            }
        }

        return answer + 1; // num 박스 포함
    }
}
package org.codingtest.inflearn.st.p5;

import java.util.*;

class Solution {
    public int solution(int[][] board){
        /*
        예를 들어, 1과 7 두 점 위에 학생이 서 있다면 둘 사이의 최소 거리는 1, 2, 3, 4, 5, 6, 7 중 하나일 것이다.
        어느 지점에 서도 모두 7만큼 거리가 생기기 때문

        (만약 0에서 만나게 되면 9만큼 거리가 생긴다)

        이 개념을 2차원에 적용하면 x축과 y축 각각 계산을 하면 중간 지점이 나오게 된다.

        에를 들어, (0, 0), (2, 4), (4, 2) 가 있을 때,
        행: 0, 2, 4
        열: 0, 4, 2
        가 되고 정렬을 하면
        행: 0, 2, 4
        열: 0, 2, 4
        가 된다.

        그럴 경우
        행은 0 과 4 사이, 2에서 만나고
        열은 0 과 4 사이, 2에서 만나면 중간 지점이 된다.
         */
        List<Integer> row = new ArrayList<>();
        List<Integer> column = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        Collections.sort(row);
        Collections.sort(column);

        int middleRow = row.get(row.size() / 2);
        int middleColumn = column.get(column.size() / 2);

        return calculateDistance(middleRow, middleColumn, row, column);
    }

    public int calculateDistance(int i, int j, List<Integer> row, List<Integer> column) {
        int distance = 0;
        for (int k = 0; k < row.size(); k++) {
            distance += (Math.abs(row.get(k) - i) + Math.abs(column.get(k) - j));
        }
        return distance;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
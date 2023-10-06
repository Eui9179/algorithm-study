package org.codingtest.inflearn.st.p5;

import java.util.*;

class Solution {
    public int solution(int[][] board){
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
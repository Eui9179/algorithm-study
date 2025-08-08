package org.codingtest.book.part2.ch4;

public class P116 {
    public static void main(String[] args) {
        System.out.println(solution("a1"));
        System.out.println(solution("c2"));
    }

    public static int solution(String position) {
        int answer = 0;

        int[] index = {(int) position.charAt(0) - 97, Integer.parseInt(position.substring(1, 2)) - 1};

        int[][] moves = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}};

        for (int[] move : moves) {
            int nextA = index[0] + move[0];
            int nextB = index[1] + move[1];

            if (nextA >= 0 && nextA < 8 && nextB >= 0 && nextB < 8) {
                answer++;
            }
        }

        return answer;
    }
}

package org.codingtest.book.part2.ch4;

public class P114 {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        int count = 0;
        for (int hour = 0; hour <= n; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                for (int second = 0; second < 60; second++) {
                    if (String.valueOf(hour).contains("3") ||
                            String.valueOf(minute).contains("3") ||
                            String.valueOf(second).contains("3")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

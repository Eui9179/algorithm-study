package org.codingtest.book.part2.ch3;

public class P100 {
    public static void main(String[] args) {
        System.out.println(solution(25, 3));
    }

    public static int solution(int n, int k) {
        int count = 0;
        while (n != 1) {
            if (n % k == 0) n /= k;
            else n--;
            count++;
        }
        return count;
    }
}

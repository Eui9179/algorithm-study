package org.codingtest;
import java.util.ArrayList;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static long solution() {
        return LongStream.range(1, 100000)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();
    }
}
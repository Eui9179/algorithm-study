package org.codingtest;
import java.util.*;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        int nums = 12345;
        int sum = 0;

        while (nums != 0) {
            sum += nums % 10;
            nums /= 10;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        System.out.println(sum);
    }
}
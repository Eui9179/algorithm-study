package org.codingtest.level0;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] array, int n) {
        return (int) Arrays.stream(array).filter(i -> i == n).count();
    }

    public static void main(String[] args) {}
}

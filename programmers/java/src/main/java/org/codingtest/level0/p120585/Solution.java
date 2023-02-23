package org.codingtest.level0.p120585;
import java.util.Arrays;
public class Solution {
    public static int solution(int[] array, int height) {
        return (int)Arrays.stream(array).filter(h -> h > height).count();
    }
    public static void main(String[] args) {
        int[] array = {149, 180, 192, 170};
        System.out.println(solution(array, 167));
    }
}

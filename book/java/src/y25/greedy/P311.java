package y25.greedy;

import java.util.*;

public class P311 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 1, 2, 2}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution(new int[]{2, 2, 2, 2, 2, 2}));
        System.out.println(solution(new int[]{3, 3, 3}));
        System.out.println(solution(new int[]{3, 3, 4}));
        System.out.println(solution(new int[]{4}));
    }

    private static int solution(int[] arr) {
        int result = 0, count = 0;
        Arrays.sort(arr);

        for (int a : arr) {
            if (++count == a) {
                count = 0;
                result++;
            }
        }

        return result;
    }
}

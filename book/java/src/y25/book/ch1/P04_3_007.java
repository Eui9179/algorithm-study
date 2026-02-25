package y25.book.ch1;

import java.util.Arrays;

public class P04_3_007 {

    public static void main(String[] args) {
        System.out.println(solution(9, new int[]{1, 2, 3, 4, 5, 7}));
    }

    private static int solution(int target, int[] arr) {
        Arrays.sort(arr);
        int answer = 0, s = 0, e = arr.length - 1;

        while (s < e) {
            if (arr[s] + arr[e] < target) {
                s++;
            } else if (arr[s] + arr[e] > target) {
                e--;
            } else {
                answer++;
                s++;
            }
        }
        return answer;
    }
}

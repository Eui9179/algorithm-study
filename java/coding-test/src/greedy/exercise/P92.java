/*큰 수의 법칙*/
package greedy.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P92 {
    public static void solution(ArrayList<Integer> numbers, int k, int m) {
        Collections.sort(numbers, Collections.reverseOrder());
        int max1 = numbers.get(0);
        int max2 = numbers.get(1);
        int max2Count = m / (k + 1);

        int result = (max1 * (m - max2Count)) + (max2 * max2Count);

        System.out.println("result = " + result);
    }
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2, 4, 5, 4, 6));
        int m = 8;
        int k = 2;

        solution(numbers, k, m);

    }
}

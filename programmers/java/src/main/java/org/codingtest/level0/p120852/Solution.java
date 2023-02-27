package org.codingtest.level0.p120852;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                if (isPrime(i)) {
                    answer.add(i);
                }
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}

package org.codingtest.level1.p12935;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().orElse(Integer.MIN_VALUE);
        int[] result = Arrays.stream(arr).filter(n -> n != min).toArray();
        return result.length == 0 ? new int[] {-1} : result;
    }
}

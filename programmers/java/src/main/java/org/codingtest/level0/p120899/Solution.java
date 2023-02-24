package org.codingtest.level0.p120899;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        int max = Collections.max(list);
        int index = list.indexOf(max);
        return new int[]{max, index};
    }
}
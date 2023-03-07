package org.codingtest.level1.p12932;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(long n) {
        String[] nStr = String.valueOf(n).split("");
        List<String> sList = new ArrayList<>(Arrays.asList(nStr));
        Collections.reverse(sList);
        return sList.stream().mapToInt(Integer::parseInt).toArray();
    }

}
package org.codingtest.level0.p120906;

import java.util.*;
class Solution {
    public int solution(int n) {
        return Arrays
                .stream(String.valueOf(n).split(""))
                .mapToInt(Integer::valueOf).sum();
    }
}
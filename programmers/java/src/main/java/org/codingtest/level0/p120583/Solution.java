package org.codingtest.level0.p120583;
import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        return (int)Arrays.stream(array).filter(num -> num == n).count();
    }
}
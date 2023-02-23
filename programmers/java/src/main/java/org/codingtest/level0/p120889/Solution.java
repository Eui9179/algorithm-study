package org.codingtest.level0.p120889;
import java.util.*;
public class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        return (sides[0] + sides[1] > sides[2]) ? 1 : 2;
    }
}

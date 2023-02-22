package org.codingtest.level0;
import java.util.*;
public class Solution {
    public int[] solution(int money) {
        //아메리카노 5500
        int[] answer = new int[2];
        answer[0] = money / 5500;
        answer[1] = money % 5500;
        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(15000);
    }
}

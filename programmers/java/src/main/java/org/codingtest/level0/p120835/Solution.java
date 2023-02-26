package org.codingtest.level0.p120835;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        List<Integer> emergencyList = Arrays.stream(emergency).boxed().collect(Collectors.toList());
        List<Integer> emergencyListCopy = new ArrayList<>(emergencyList);

        emergencyListCopy.sort(Collections.reverseOrder());

        System.out.println("emergencyList = " + emergencyList);
        System.out.println("emergencyListCopy = " + emergencyListCopy);

        for (int i = 0; i < emergencyList.size(); i++) {
            answer[i] = emergencyListCopy.indexOf(emergencyList.get(i)) + 1;
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 3, 4, 5, 6, 7});
    }
}

package org.codingtest.level2.p17687;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(16, 16, 2, 2));
    }
    public String solution(int n, int t, int m, int p) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= t * m; i++) {
            String[] nStr = Integer.toString(i, n).split("");
            list.addAll(Arrays.asList(nStr));
        }

        for (int i = p; i <= t * m; i += m) {
            if ((i / m) - 1 > t) {
                break;
            }
            sb.append(list.get(i - 1));
        }

        return sb.toString().toUpperCase();
    }
}

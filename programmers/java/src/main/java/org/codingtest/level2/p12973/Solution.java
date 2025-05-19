package org.codingtest.level2.p12973;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("baabaa"));
    }

    public int solution(String s) {
        return operateStack(s.split("")) ? 1 : 0;
    }

    public boolean operateStack(String[] strings) {
        ArrayList<String> stack = new ArrayList<>();
        for (String string : strings) {
            if (stack.isEmpty()) {
                stack.add(string);
            } else if (stack.get(stack.size() - 1).equals(string)) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(string);
            }
        }
        return stack.isEmpty();
    }

    public boolean removeTwice(List<String> strings) {
        int i = 0;
        int j = 1;

        while (j < strings.size()) {
            if (strings.get(i).equals(strings.get(j))) {
                strings.remove(i);
                strings.remove(i);

                if (i > 0) {
                    i--;
                    j--;
                }
            } else {
                i++;
                j++;
            }
        }
        return strings.isEmpty();
    }
}
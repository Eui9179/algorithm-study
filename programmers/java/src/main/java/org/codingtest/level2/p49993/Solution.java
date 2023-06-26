package org.codingtest.level2.p49993;

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String[] skills = skill.split("");

        for (String skill_tree : skill_trees) {
            List<String> stack = new ArrayList<>(Arrays.asList(skills));
            boolean available = true;
            for (String s : skill_tree.split("")) {
                if (stack.contains(s)) {
                    if (stack.get(0).equals(s)) {
                        stack.remove(0);
                    } else {
                        available = false;
                        break;
                    }
                }
            }
            if (available) answer++;
        }


        return answer;
    }
}
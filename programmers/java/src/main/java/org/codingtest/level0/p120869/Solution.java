package org.codingtest.level0.p120869;

class Solution {
    public int solution(String[] spell, String[] dic) {
        for (String d : dic) {
            boolean isCheck = true;
            for (String s : spell) {
                if (!d.contains(s)) {
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) {
                return 1;
            }
        }
        return 2;
    }
}
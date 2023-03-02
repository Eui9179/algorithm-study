package org.codingtest.level0.p120863;

class Solution {
    public String solution(String polynomial) {
        if (polynomial.equals("0") || polynomial.equals(" ")) {
            return "0";
        }

        String answer = "";
        int xNum = 0;
        int num = 0;

        String[] split = polynomial.split(" \\+ ");
        for (String s : split) {
            if (s.contains("x")) {
                xNum += s.length() == 1 ? 1 : Integer.parseInt(s.replace("x", ""));
            } else {
                num += Integer.parseInt(s);
            }
        }

        if (xNum == 1) {
            answer += "x";
        }
        else if (xNum != 0) {
            answer += xNum + "x";
        }
        if (num != 0) {
            if (xNum != 0) answer += " + ";
            answer += num;
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().solution("10x + x"));
    }
}
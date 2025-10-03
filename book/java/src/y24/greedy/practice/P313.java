package y24.greedy.practice;

public class P313 {
    public int solution(String s) {
        int answer1 = s.length() - s.replace("10", "2").length();
        int answer0 = s.length() - s.replace("01", "2").length();

        if (s.charAt(s.length() - 1) == '1') answer1++;
        else answer0++;

        return Math.min(answer0, answer1);
    }
}

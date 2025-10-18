package y25.simulation;

public class P324 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));


    }

    private static int solution(String str) {
        int min = Integer.MAX_VALUE;
        String result = "";
        for (int i = str.length() / 2; i > 0; i--) {
            result = compress(str, i);
            min = Math.min(min, result.length());
        }
        return min;
    }

    private static String compress(String str, int ratio) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            if (i + ratio > str.length()) {
                result.append(str, i, str.length());
                break;
            }
            String s = str.substring(i, i + ratio);
            int count = 0;
            while (i + ratio <= str.length() && s.equals(str.substring(i, i + ratio))) {
                count++;
                i += ratio;
            }
            if (count == 1) {
                result.append(s);
            } else {
                result.append(count);
                result.append(s);
            }
        }

        return result.toString();
    }
}

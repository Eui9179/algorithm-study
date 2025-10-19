package y25.simulation;

import java.util.ArrayList;
import java.util.List;

public class P324 {
    public static void main(String[] args) {
        System.out.println(solution2("aabbaccc"));
        System.out.println(solution2("ababcdcdababcdcd"));
        System.out.println(solution2("abcabcdede"));
        System.out.println(solution2("abcabcabcabcdededededede"));
        System.out.println(solution2("xababcdcdababcdcd"));
    }

    private static int solution2(String s) {
        int min = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            min = Math.min(compress2(s, i).length(), min);
        }

        return min;
    }

    private static String compress2(String s, int ratio) {
        List<String> queue = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (i + ratio > s.length()) {
                sb.append(s.substring(i));
                break;
            }
            queue.add(s.substring(i, i + ratio));
            i += ratio;
        }

        while (!queue.isEmpty()) {
            String str = queue.get(0);
            int count = 0;
            while (!queue.isEmpty() && str.equals(queue.get(0))) {
                queue.remove(0);
                count++;
            }
            sb.append(str);
            if (count > 1) {
                sb.append(count);
            }

        }
        return sb.toString();
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

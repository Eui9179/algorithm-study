package y25.level1;

import java.util.*;

class P81301 {
    public static void main(String[] args) {
        System.out.println(new P81301().solution("one4seveneight"));
    }
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> numberMap = new HashMap<>(Map.of(
                "zero", "0",
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4",
                "five", "5",
                "six", "6",
                "seven", "7",
                "eight", "8",
                "nine", "9"
        ));

        while (s.length() != 0) {
            for (String numberStr : numberMap.keySet()) {
                if (s.startsWith(numberStr)) {
                    s = s.replaceFirst(numberStr, numberMap.get(numberStr));
                    break;
                }
            }

            sb.append(s.charAt(0));
            s = s.replaceFirst(s.substring(0, 1), "");
        }


        return Integer.parseInt(sb.toString());
    }
}
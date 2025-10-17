package y25.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P323 {
    public static void main(String[] args) {
        System.out.println(solution("K1KA5CB7"));
    }

    private static String solution(String str) {
        int sum = 0;
        List<String> strings = new ArrayList<>();
        for (String s : str.split("")) {
            try {
                sum += Integer.parseInt(s);
            } catch (RuntimeException ignored) {
                strings.add(s);
            }
        }
        Collections.sort(strings);

        StringBuilder result = new StringBuilder();
        for (String s : strings) result.append(s);
        return result.toString() + sum;
    }
}

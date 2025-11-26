package y25.level1;

import java.util.*;

public class P131128 {
    public String solution(String X, String Y) {
        String[] x = X.split("");
        Arrays.sort(x, Comparator.reverseOrder());

        Map<String, Integer> y = generateYMap(Y);
        StringBuilder sb = new StringBuilder();

        for (String s : x) {
            if (y.containsKey(s) && y.get(s) > 0) {
                y.put(s, y.get(s) - 1);
                sb.append(s);
            }
        }

        if (sb.length() == 0) return "-1";

        // 내림차순으로 정렬하였기 때문에 "0"으로 시작이면 모두 "0"
        if (sb.toString().startsWith("0")) return "0";

        return sb.toString();
    }

    private Map<String, Integer> generateYMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        String[] split = str.split("");
        for (String s : split) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }
}

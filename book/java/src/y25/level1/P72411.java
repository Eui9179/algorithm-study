package y25.level1;

import java.util.*;

public class P72411 {

    public static void main(String[] args) {
        new P72411().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<Integer, Map<String, Integer>> result = new HashMap<>();

        for (int c : course) {
            for (String order : orders) {
                List<String> permutation = new ArrayList<>();
                permute(order.split(""), c, permutation, new StringBuilder(), new boolean[order.length()], 0);
                for (String p : permutation) {
                    if (!result.containsKey(c)) {
                        result.put(c, new HashMap<>());
                    }
                    Map<String, Integer> cMap = result.get(c);
                    cMap.put(p, cMap.getOrDefault(p, 0) + 1);
                }
            }
        }
        for (int c : course) {
            Map<String, Integer> cMap = result.get(c);
            int max = Integer.MIN_VALUE;
            for (int value: cMap.values()) {
                if (value > max) max = value;
            }
            for (String p : cMap.keySet()) {
                if (cMap.get(p) == max) {
                    answer.add(p);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer);
        return answer.toArray(new String[0]);
    }

    private void permute(String[] str, int k, List<String> result, StringBuilder current, boolean[] used, int index) {
        if (current.length() == k) {
            result.add(current.toString());
            return;
        }

        for (int i = index; i < str.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.append(str[i]);
            permute(str, k, result, current, used, i);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}

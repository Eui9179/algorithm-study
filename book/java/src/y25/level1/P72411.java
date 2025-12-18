package y25.level1;

import java.util.*;

public class P72411 {

    public static void main(String[] args) {
        new P72411().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        new P72411().solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5});
        new P72411().solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<Integer, Map<String, Integer>> result = new HashMap<>();

        for (int c : course) {
            if (!result.containsKey(c)) result.put(c, new HashMap<>());
            for (String order : orders) {
                List<List<String>> permutation = new ArrayList<>();
                permute(order.split(""), c, permutation, new ArrayList<>(), new boolean[order.length()], 0);
                for (List<String> p : permutation) {
                    Collections.sort(p);
                    Map<String, Integer> cMap = result.get(c);
                    cMap.put(listToString(p), cMap.getOrDefault(listToString(p), 0) + 1);
                }
            }
        }
        System.out.println("result = " + result);
        for (int c : course) {
            Map<String, Integer> cMap = result.get(c);
            int max = Integer.MIN_VALUE;
            for (int value: cMap.values()) {
                if (value > max && value >= 2) max = value;
            }
            for (String p : cMap.keySet()) {
                if (cMap.get(p) == max) {
                    answer.add(p);
                }
            }
        }
        Collections.sort(answer);
        System.out.println("answer = " + answer);
        return answer.toArray(new String[0]);
    }

    private void permute(String[] str, int k, List<List<String>> result, List<String> current, boolean[] used, int index) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < str.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(str[i]);
            permute(str, k, result, current, used, i + 1);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    private String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}

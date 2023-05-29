package org.codingtest.level2.p17684;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().run("KAKAO")));
        System.out.println(Arrays.toString(new Solution().run("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(new Solution().run("ABABABABABABABAB")));
    }

    public int[] solution(String msg) {
        return run(msg);
    }

    public int[] run(String msg) {
        Map<String, Integer> dict = initData();
        List<String> stack = new ArrayList<>(Arrays.asList(msg.split("")));
        List<Integer> result = new ArrayList<>();
        StringBuilder sb;
        int count = dict.values().size();
        String last = "";

        while (stack.size() > 0) {
            sb = new StringBuilder();
            sb.append(stack.remove(0));

            while (stack.size() > 0 && dict.containsKey(sb.toString())) {
                last = stack.remove(0);
                sb.append(last);
            }

            if (!dict.containsKey(sb.toString())) {
                dict.put(sb.toString(), ++count);
            } else if (stack.size() == 0) {
                result.add(dict.get(sb.toString()));
                return result.stream().mapToInt(Integer::intValue).toArray();
            }

            stack.add(0, last);
            sb.deleteCharAt(sb.length() - 1);
            result.add(dict.get(sb.toString()));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public Map<String, Integer> initData() {
        Map<String, Integer> result = new LinkedHashMap<>();
        char a = 'A';

        for (int i = 0; i < 26; i++) {
            String key = Character.toString(a + i);
            result.put(key, i + 1);
        }
        return result;
    }
}

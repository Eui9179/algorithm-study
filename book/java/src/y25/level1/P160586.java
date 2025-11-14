package y25.level1;

import java.util.*;

public class P160586 {
    public int[] solution(String[] keymap, String[] targets) {

        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> keyMap = new HashMap<>();

        for (String key : keymap) {
            String[] each = key.split("");
            for (int i = 0; i < each.length; i++) {
                if (keyMap.containsKey(each[i])) {
                    keyMap.put(each[i], Math.min(keyMap.get(each[i]), i + 1));
                } else {
                    keyMap.put(each[i], i + 1);
                }
            }
        }

        for (String target : targets) {
            int result = 0;
            for (String t : target.split("")) {
                if (!keyMap.containsKey(t)) {
                    result = -1;
                    break;
                }
                result += keyMap.get(t);
            }
            answer.add(result);
        }

        return answer.stream()
                .mapToInt(a -> a)
                .toArray();
    }
}

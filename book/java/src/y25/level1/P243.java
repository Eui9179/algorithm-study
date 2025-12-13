package y25.level1;

import java.util.*;

public class P243 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String parti: participant) {
            map.put(parti, map.getOrDefault(parti, 0) + 1);
        }

        for (String comp : completion) {
            map.put(comp, map.get(comp) - 1);
            if (map.get(comp) == 0) {
                map.remove(comp);
            }
        }

        for (String key : map.keySet())
            answer = key;

        return answer;
    }
}

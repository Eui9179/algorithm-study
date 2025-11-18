package y25.level1;

import java.util.*;

public class P142086 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        Map<String, Integer> wordMap = new HashMap<>();
        String[] split = s.split("");

        for (int i = 0; i < split.length; i++) {
            if (wordMap.containsKey(split[i])) {
                int wordIndex = wordMap.remove(split[i]);
                answer[i] = i - wordIndex;
                wordMap.put(split[i], i);
            } else {
                wordMap.put(split[i], i);
            }
        }

        return answer;
    }
}

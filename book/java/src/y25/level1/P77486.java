package y25.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P77486 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        String start = "-";

        Map<String, String> graph = new HashMap<>();
        Map<String, Integer> record = new HashMap<>();
        Set<String> visited = new HashSet<>();

        graph.put("-", null);
        record.put(start, 0);

        for (int i = 0; i < enroll.length; i++) {
            graph.put(enroll[i], referral[i]);
            record.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            String node = seller[i];
            int sa = amount[i] * 100;

            while (true) {
                record.put(node, record.get(node) + sa);
                if (graph.get(node) == null || sa / 10 < 1) {
                    break;
                }

                sa /= 10;
                record.put(node, record.get(node) - sa);

                node = graph.get(node);
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = record.get(enroll[i]);
        }
        return answer;
    }
}

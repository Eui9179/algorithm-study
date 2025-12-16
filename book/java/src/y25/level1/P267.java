package y25.level1;

import java.util.*;

public class P267 {
    public static void main(String[] args) {
        int[] solution = new P267().solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        System.out.println(Arrays.toString(solution));
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> rMap = new HashMap<>();
        Map<String, Set<String>> rList = new HashMap<>();
        Map<String, Integer> notiMap = new HashMap<>();

        for (String id : id_list) {
            rMap.put(id, 0);
            rList.put(id, new HashSet<>());
            notiMap.put(id, 0);
        }

        for (String rep : report) {
            String[] split = rep.split(" ");
            String id = split[0];
            String reported = split[1];

            if (!rList.get(reported).contains(id)) {
                rMap.put(reported, rMap.get(reported) + 1);
            }
            rList.get(reported).add(id);
        }

        for (String id : rMap.keySet()) {
            if (rMap.get(id) >= k) {
                for (String needNoti : rList.get(id)) {
                    notiMap.put(needNoti, notiMap.get(needNoti) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = notiMap.get(id_list[i]);
        }

        return answer;
    }
}

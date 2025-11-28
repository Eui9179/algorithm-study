package y25.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
["muzi", "frodo", "apeach", "neo"] 	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"] 	2 	[2,1,1,0]
["con", "ryan"] 	["ryan con", "ryan con", "ryan con", "ryan con"] 	3 	[0,0]
 */
public class P92334 {
    public static void main(String[] args) {
        new P92334().solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                2);
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportedMap = new HashMap<>();
        Map<String, Integer> idIndexMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportedMap.put(id_list[i], new HashSet<>());
            idIndexMap.put(id_list[i], i);
        }

        for (String rp : report) {
            String[] split = rp.split(" ");
            String from = split[0];
            String to = split[1];
            reportedMap.get(to).add(from);
        }

        for (String id : id_list) {
            int reportCount = reportedMap.get(id).size();
            if (reportCount >= k) {
                Set<String> needNoti = reportedMap.get(id);
                for (String noti : needNoti) {
                    answer[idIndexMap.get(noti)]++;
                }
            }
        }

        return answer;
    }
}

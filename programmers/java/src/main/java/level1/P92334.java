package level1;

import java.util.*;

public class P92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(report));
        String[] reportD = linkedHashSet.toArray(new String[]{});

        HashMap<String, ArrayList<String>> noti = new HashMap<>();
        for (String id : id_list) {
            noti.put(id, new ArrayList<>());
        }

        for (String r : reportD) {
            String[] splitedReport = r.split(" ");
            noti.get(splitedReport[1]).add(splitedReport[0]);
        }

        for (String n : noti.keySet()) {
            if (noti.get(n).size() >= k) {
                for (String reporter : noti.get(n)){
                    answer[(Arrays.asList(id_list).indexOf(reporter))] += 1;
                }
            }
        }

        return answer;
    }
}

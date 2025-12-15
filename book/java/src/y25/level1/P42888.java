package y25.level1;

import java.util.*;

public class P42888 {
    /*
    ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
    ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
     */
    public String[] solution(String[] record) {
        Map<String, String> idMap = new HashMap<>();
        List<String[]> results = new ArrayList<>();

        for (String rc : record) {
            String[] split = rc.split(" ");
            if (split[0].equals("Leave")) {
                results.add(new String[]{split[1], "님이 나갔습니다."});
            } else {
                idMap.put(split[1], split[2]);
                if (split[0].equals("Enter")) {
                    results.add(new String[]{split[1], "님이 들어왔습니다."});
                }
            }
        }

        return results.stream()
                .map(result -> idMap.get(result[0]) + result[1])
                .toArray(String[]::new);
    }
}

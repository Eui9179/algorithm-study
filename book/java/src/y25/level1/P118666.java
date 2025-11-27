package y25.level1;

import java.util.*;
/*
["AN", "CF", "MJ", "RT", "NA"] 	[5, 3, 2, 7, 5] 	"TCMA"
["TR", "RT", "TR"] 	[7, 1, 3] 	"RCJA"
1 	매우 비동의 3
2 	비동의 2
3 	약간 비동의 1
4 	모르겠음 0
5 	약간 동의 -1
6 	동의 -2
7 	매우 동의 -3
 */
public class P118666 {

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<String, Integer> table = new HashMap<>(Map.of(
                "A", 0, "N", 0,
                "R", 0, "T", 0,
                "C", 0, "F", 0,
                "J", 0, "M", 0)
        );

        for (int i = 0; i < survey.length; i++) {
            String no = String.valueOf(survey[i].charAt(0));
            String yes = String.valueOf(survey[i].charAt(1));

            int score = 4 - choices[i];
            if (score > 0) {
                table.put(no, table.get(no) + Math.abs(score));
            } else if (score < 0) {
                table.put(yes, table.get(yes) + Math.abs(score));
            }
        }

        if (table.get("R") >= table.get("T")) answer += "R";
        else answer += "T";

        if (table.get("C") >= table.get("F")) answer += "C";
        else answer += "F";

        if (table.get("J") >= table.get("M")) answer += "J";
        else answer += "M";

        if (table.get("A") >= table.get("N")) answer += "A";
        else answer += "N";

        return answer;
    }
}


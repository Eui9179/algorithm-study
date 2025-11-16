package y25.level1;

import java.util.ArrayList;
import java.util.List;

public class P155652 {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        List<String> alpha = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

        for (String sk: skip.split("")) {
            while (alpha.contains(sk))
                alpha.remove(sk);
        }

        for (String str: s.split("")) {
            int strIndex = alpha.indexOf(str);
            int nextIndex = strIndex + index;

            if (nextIndex >= alpha.size()) {
                int over = nextIndex - alpha.size();
                while (over >= alpha.size())
                    over -= alpha.size();
                answer.append(alpha.get(over));
            } else {
                answer.append(alpha.get(nextIndex));
            }
        }

        return answer.toString();
    }
}

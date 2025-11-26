package y25.level1;

import java.util.ArrayList;
import java.util.List;

public class P133499 {
    public int solution(String[] babbling) {
        int answer = 0;

        for (String bab : babbling) {
            int i = 0;
            boolean can = true;
            List<String> stack = new ArrayList<>();
            stack.add("dummy");

            while (i < bab.length()) {
                if (bab.startsWith("aya", i) &&
                        !stack.get(stack.size() - 1).equals("aya")) {
                    i += 3;
                    stack.add("aya");
                } else if (bab.startsWith("ye", i) &&
                        !stack.get(stack.size() - 1).equals("ye")) {
                    i += 2;
                    stack.add("ye");
                } else if (bab.startsWith("woo", i) &&
                        !stack.get(stack.size() - 1).equals("woo")) {
                    i += 3;
                    stack.add("woo");
                } else if (bab.startsWith("ma", i) &&
                        !stack.get(stack.size() - 1).equals("ma")) {
                    i += 2;
                    stack.add("ma");
                } else {
                    can = false;
                    break;
                }
            }
            if (can) answer++;
        }
        return answer;
    }
}

package y25.level1;

import java.util.*;

public class P81303 {

    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        String[] result = new String[n];

        Deque<int[]> deleteHistory = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
            list.add(new int[]{i, i});

        for (String command : cmd) {
            String[] split = command.split(" ");
            String direction = split[0];
            String offset;

            if (direction.equals("D")) {
                offset = split[1];
                k += Integer.parseInt(offset);
            } else if (direction.equals("U")) {
                offset = split[1];
                k -= Integer.parseInt(offset);
            } else if (direction.equals("C")) {
                int[] push = list.remove(k);
                push[1] = k;
                deleteHistory.push(push);
                if (k >= list.size())
                    k = list.size() - 1;
            } else {
                int[] pop = deleteHistory.pop();
                if (pop[1] >= list.size()) {
                    list.add(pop);
                } else {
                    list.add(pop[1], pop);
                }
                if (pop[1] <= k) k++;
            }
        }

        for (int[] node : list) {
            result[node[0]] = "O";
        }

        for (int[] node : deleteHistory) {
            result[node[0]] = "X";
        }

        for (String r : result) {
            answer.append(r);
        }

        return answer.toString();
    }
}

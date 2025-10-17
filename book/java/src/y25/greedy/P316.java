package y25.greedy;

import java.util.ArrayList;
import java.util.List;

public class P316 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 3, 2}));
        System.out.println(solution(new int[]{1, 5, 4, 3, 2, 4, 2, 5}));
    }

    private static int solution(int[] balls) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, balls, 2, new ArrayList<>(), 0);
        System.out.println(result);
        return result.size();
    }

    private static void combine(List<List<Integer>> result, int[] cases, int pickSize, List<Integer> tmp, int index) {
        if (tmp.size() == pickSize) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < cases.length; i++) {
            if (tmp.contains(cases[i])) continue;
            tmp.add(cases[i]);
            combine(result, cases, pickSize, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

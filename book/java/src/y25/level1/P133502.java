package y25.level1;

import java.util.ArrayList;
import java.util.List;

public class P133502 {

    public int solution(int[] ingredient) {
        int answer = 0;

        List<Integer> stack = new ArrayList<>();
        for (int i = 0; i < ingredient.length; i++) {
            stack.add(ingredient[i]);
            if (generateBurger(stack)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean generateBurger(List<Integer> stack) {
        if (stack.size() < 4) return false;
        List<Integer> seq = List.of(1, 3, 2, 1);
        for (int i = 1; i <= 4; i++) {
            if (stack.get(stack.size() - i) != seq.get(i - 1))
                return false;
        }
        for (int i = 0; i < 4; i++) {
            stack.remove(stack.size() - 1);
        }
        return true;
    }
}

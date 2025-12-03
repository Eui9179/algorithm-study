package y25.level1;

import java.util.*;

public class P68644 {
    public int[] solution(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                numberSet.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> answer = new ArrayList<>(numberSet);
        Collections.sort(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

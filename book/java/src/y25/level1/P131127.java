package y25.level1;

import java.util.*;

public class P131127 {
    public static void main(String[] args) {
        //"banana", "apple", "rice", "pork", "pot"
        //1,         -1,         0,      0,      1
        int answer = new P131127().solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
        System.out.println("answer = " + answer);
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++)
            wantMap.put(want[i], number[i]);

        int j = 0;

        while (j < discount.length && j < 10) { // 초기값 설정
            if (wantMap.containsKey(discount[j]))
                wantMap.put(discount[j], wantMap.get(discount[j]) - 1);
            j++;
        }

        if (sum(wantMap) == 0) {
            answer++;
        }

        if (discount.length < 10) {
            return answer;
        }

        int i = 0;
        while (j < discount.length) {
            if (wantMap.containsKey(discount[i])) { // 이전 값 복원
                wantMap.put(discount[i], wantMap.get(discount[i]) + 1);
            }

            if (wantMap.containsKey(discount[j])) {
                wantMap.put(discount[j], wantMap.get(discount[j]) - 1);
                if (sum(wantMap) == 0)
                    answer++;
            }
            i++;
            j++;
        }

        return answer;
    }

    private int sum(Map<String, Integer> wantMap) {
        int sum = 0;
        for (int value : wantMap.values()) {
            if (value > 0) sum += value;
        }
        return sum;
    }
}

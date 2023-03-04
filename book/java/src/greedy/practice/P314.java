package greedy.practice;

import java.util.*;

public class P314 {
    public int solution(int[] nums) {
        Integer[] inums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(inums, Collections.reverseOrder());
        int n;

        for (int i = 1; ; i++) {
            n = i;
            for (Integer num : inums) {
                n -= num;
                if (n == 0) break;
                else if (n < 0) n += num;
            }
            if (n > 0) {
                return i;
            }
        }
    }
}

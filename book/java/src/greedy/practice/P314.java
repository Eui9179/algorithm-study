package greedy.practice;

import java.util.*;

public class P314 {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int n;

        for (int i = 1; ; i++) {
            n = i;
            for (Integer num : nums) {
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

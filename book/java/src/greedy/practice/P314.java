package greedy.practice;

import java.util.*;

public class P314 {
    public int solution(int[] nums) {
        Arrays.sort(nums);

        int answer = 1;

        for (int num : nums) {
            if (num > answer) {
                break;
            }
            answer += num;
        }
        return answer;
    }
}

package y25.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class P315 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 2, 3, 9}));

    }

    private static int solution(int[] nums) {
        // 1 1 2 3 9 -> 8

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int[] memory = new int[sum + 1];

        for (int i = 1; i <= nums.length; i++) {
            List<List<Integer>> result = new ArrayList<>();
            combine(result, nums, i, new ArrayList<>(), 0);

            for (List<Integer> r : result) {
                int tmpSum = 0;
                for (int value : r) {
                    tmpSum += value;
                }
                memory[tmpSum] = tmpSum;
            }
        }

        for (int i = 1; i < memory.length; i++) {
            if (memory[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    private static void combine(List<List<Integer>> result, int[] nums, int pickSize, List<Integer> tmp, int index) {
        if (tmp.size() == pickSize) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            combine(result, nums, pickSize, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

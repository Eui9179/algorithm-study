package y25.greedy;

import java.util.ArrayList;
import java.util.List;

public class P314R {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        combine(result, nums, 3, new ArrayList<>(), 0);
        System.out.println("result = " + result);
    }

    private static void combine(
            List<List<Integer>> result,
            int[] nums,
            int pickCount,
            List<Integer> tmp,
            int index
    ) {
        if (tmp.size() == pickCount) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            combine(result, nums, pickCount, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

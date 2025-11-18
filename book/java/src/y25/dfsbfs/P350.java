package y25.dfsbfs;

import java.util.*;

public class P350 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 6}, new int[]{0, 0, 1, 0})));
        System.out.println(Arrays.toString(solution(new int[]{3, 4, 5}, new int[]{1, 0, 1, 0})));
    }

    private static int[] solution(int[] nums, int[] kinds) {
        int maxAnswer = 0;
        int minAnswer = Integer.MAX_VALUE;

        List<String> kindStrings = new ArrayList<>();

        for (int i = 0; i < kinds.length; i++) {
            for (int j = 0; j < kinds[i]; j++) {
                if (i == 0) {
                    kindStrings.add("+");
                } else if (i == 1) {
                    kindStrings.add("-");
                } else if (i == 2) {
                    kindStrings.add("*");
                } else {
                    kindStrings.add("/");
                }
            }
        }

        List<List<String>> permutation = new ArrayList<>();
        permutation(permutation, kindStrings, nums.length - 1, new ArrayList<>(), new boolean[kindStrings.size()]);
        System.out.println("permutation = " + permutation);

        for (List<String> kind : permutation) {
            int result = nums[0];
            for (int i = 0; i < kind.size(); i++) {
                String k = kind.get(i);
                switch (k) {
//                    case "+" -> result += nums[i + 1];
//                    case "-" -> result -= nums[i + 1];
//                    case "*" -> result *= nums[i + 1];
//                    case "/" -> result = nums[i + 1] < 0 ?
//                            -(result / Math.abs(nums[i + 1])) : result / nums[i + 1];
                }
            }

            minAnswer = Math.min(minAnswer, result);
            maxAnswer = Math.max(maxAnswer, result);
        }

        return new int[]{minAnswer, maxAnswer};
    }

    private static void permutation(
            List<List<String>> result,
            List<String> kinds,
            int k,
            List<String> current,
            boolean[] used
    ) {

        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < kinds.size(); i++) {
            if (used[i]) continue;
            current.add(kinds.get(i));
            used[i] = true;
            permutation(result, kinds, k, current, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

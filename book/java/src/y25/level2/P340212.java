package y25.level2;

import java.util.Arrays;

class P340212 {
    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = Arrays.stream(diffs).max().getAsInt();

        while (left < right) {
            long mid = (left + right) / 2;

            if (canSolve(mid, diffs, times, limit)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    private boolean canSolve(long level, int[] diffs, int[] times, long limit) {
        long total = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                if (i == 0) {
                    total += (diffs[i] - level) * times[i] + times[i];
                } else {
                    total += (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
                }
            }
            if (total > limit) return false;
        }
        return true;
    }

}
package y25.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P198 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, 3, 7, 9, 2}, new int[]{5, 7, 9}));
    }

    private static List<String> solution(int[] array, int[] checkList) {
        List<String> result = new ArrayList<>();
        Arrays.sort(array);

        for (int target : checkList) {
            int start = 0;
            int end = array.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (array[mid] == target) {
                    result.add("Y");
                    break;
                } else if (array[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (start > end) {
                result.add("N");
            }
        }
        return result;
    }
}

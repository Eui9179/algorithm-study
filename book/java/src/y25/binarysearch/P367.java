package y25.binarysearch;

public class P367 {
    public static void main(String[] args) {

    }

    private static void solution(int[] nums) {
        // 1 1 2 2 2 2 3


    }

    // 가장 왼쪽
    private static int binarySearch(int[] nums, int k) {
        int left = 0, right = nums.length;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > k) right = mid - 1;
            else if (nums[mid] < k) left = mid + 1;
            else {
                result = mid;
                right = mid - 1;
            };
        }
        return result;
    }
}

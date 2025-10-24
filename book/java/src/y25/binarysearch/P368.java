package y25.binarysearch;

public class P368 {
    public static void main(String[] args) {
        solution(new int[]{-2, -1, 1, 3, 7});
    }

    private static void solution(int[] nums) {
        System.out.println(binarySearch(nums));
    }

    private static int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                return nums[mid];
            } else if (nums[mid] > mid) {
                right = mid - 1;
            } else if (nums[mid] < mid) {
                left = mid + 1;
            }
        }
        return -1;
    }
}

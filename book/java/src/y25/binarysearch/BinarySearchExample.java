package y25.binarysearch;


public class BinarySearchExample {
    public static void main(String[] args) {
        System.out.println(binarySearchRec(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 2, 0, 9));
        System.out.println(binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 2, 0, 9));
    }

    public static int binarySearch(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (array[mid] == target) return mid;
            else if (array[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }

    public static int binarySearchRec(int[] array, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearchRec(array, target, start, mid - 1);
        }

        return binarySearchRec(array, target, mid + 1, end);
    }
}

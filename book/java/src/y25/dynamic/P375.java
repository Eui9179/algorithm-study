package y25.dynamic;

public class P375 {
    public static void main(String[] args) {
        solution(new int[][]{
                {1, 2, 0},
                {3, 1, 6},
                {3, 4, 4},
                {2, 1, 7}
        });
    }

    private static void solution(int[][] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (j == 0) {
                    nums[i][j] += Math.max(nums[i - 1][j], nums[i - 1][j + 1]);
                } else if (j == nums[i].length - 1) {
                    nums[i][j] += Math.max(nums[i - 1][j], nums[i - 1][j - 1]);
                } else {
                    nums[i][j] += Math.max(Math.max(nums[i - 1][j - 1], nums[i - 1][j]), nums[i - 1][j + 1]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < nums[0].length; i++) {
            answer = Math.max(answer, nums[nums.length - 1][i]);
        }
        System.out.println(answer);
    }
}

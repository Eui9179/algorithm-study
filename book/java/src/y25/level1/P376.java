package y25.level1;

public class P376 {
    public static void main(String[] args) {
        solution(new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        });
    }

    private static void solution(int[][] arr) {
        // j, j + 1
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0) {
                    arr[i][j] += arr[i - 1][j];
                } else if (j == arr[i].length - 1) {
                    arr[i][j] += arr[i - 1][j - 1];
                } else {
                    arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < arr[arr.length - 1].length; i++) {
            answer = Math.max(answer, arr[arr.length - 1][i]);
        }
        System.out.println("answer = " + answer);
    }
}

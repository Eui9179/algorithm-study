package y24.implementations.practice;

public class P325 {
    public boolean solution(int[][] key, int[][] lock) {
        int[][] initArr = new int[lock.length + 2*(key.length - 1)][lock.length + 2*(key.length - 1)];
        int[][] testArr = new int[lock.length + 2*(key.length - 1)][lock.length + 2*(key.length - 1)];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                initArr[i + key.length - 1][j + key.length - 1] = lock[i][j];
                testArr[i + key.length - 1][j + key.length - 1] = lock[i][j];
            }
        }

        for (int i = 0; i < testArr.length - key.length + 1; i++) {
            for (int j = 0; j < testArr.length - key.length + 1; j++) {
                for (int k = 0; k < 4; k++) {
                    key = rotate_90(key);
                    for (int l = 0; l < key.length; l++) {
                        for (int m = 0; m < key.length; m++) {
                            testArr[i + l][j + m] = testArr[i + l][j + m] + key[l][m];
                        }
                    }
                    if (isUnlock(testArr, key, lock)) {
                        return true;
                    }
                    for (int l = 0; l < key.length; l++) {
                        for (int m = 0; m < key.length; m++) {
                            testArr[i + l][j + m] -= key[l][m];
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isUnlock(int[][] testArr, int[][] key, int[][]lock) {
        for (int i = key.length - 1; i < lock.length + key.length - 1; i++) {
            for (int j = key.length - 1; j < lock.length + key.length - 1; j++) {
                if (testArr[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] rotate_90(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] newArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newArr[j][n - i - 1] = arr[i][j];
            }
        }
        return newArr;
    }

    public static void showArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        P325 p = new P325();
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };

        System.out.println(p.solution(key, lock));

    }
}

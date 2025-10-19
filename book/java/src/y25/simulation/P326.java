package y25.simulation;

public class P326 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0, 0, 0}, // 0 1 0
                {1, 0, 0}, // 1 0 0
                {0, 1, 1}  // 1 0 0
        }, new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        }));

    }

    private static boolean solution(int[][] key, int[][] lock) {
        // 1. lock을 키 크기 - 1 만큼 map 늘림
        int expandSize = (key.length - 1) * 2;
        int[][] expandLock = expandLock(lock, expandSize);
        // 2. key를 [0, 0] 부터 확인
        int[] start = {key.length - 1, key.length - 1};
        int[] end = {key.length - 1 + lock.length, key.length - 1 + lock.length};
        for (int i = 0; i < expandLock.length - key.length; i++) {
            for (int j = 0; j < expandLock.length - key.length; j++) {
                for (int k = 0; k < 4; k++) {
                    if (isCollect(expandLock, key, i, j, start, end)) return true;
                    // 3. 없으면 key 90도 돌림
                    key = rotate90(key);
                }
            }
        }

        return false;
    }

    private static int[][] expandLock(int[][] lock, int size) {
        int[][] result = new int[lock.length + size][lock.length + size];
        for (int i = lock.length - 1; i < lock.length * 2 - 1; i++) {
            for (int j = lock.length - 1; j < lock.length * 2 - 1; j++) {
                result[i][j] = lock[i - lock.length + 1][j - lock.length + 1];
            }
        }
        return result;
    }

    private static boolean isCollect(int[][] lock, int[][]key, int i, int j, int[] start, int[] end) {
        // 배열 복사
        int[][] copy = new int[lock.length][lock.length];
        for (int k = 0; k < lock.length; k++) {
            System.arraycopy(lock[k], 0, copy[k], 0, lock.length);
        }

        // key 를 lock 과 합침
        for (int k = 0; k < key.length; k++) {
            for (int m = 0; m < key.length; m++) {
                if (copy[k + i][m + j] != 1) {
                    copy[k + i][m + j] = key[k][m];
                }
            }
        }

        for (int k = start[0]; k < end[0]; k++) {
            for (int m = start[0]; m < end[1]; m++) {
                if (copy[k][m] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] rotate90(int[][] key) {
        int[][] result = new int[key.length][key[0].length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                result[j][key.length - 1 - i] = key[i][j];
            }
        }
        return result;
    }
}

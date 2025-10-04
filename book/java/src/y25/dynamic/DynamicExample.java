package y25.dynamic;

/**
 * 다이나믹은 한 번 해결한 문제는 캐싱을 해두었다가 가져오는 특징이 있다.
 * 수열이 대표적인 예시이다.
 * f(10)을 호출하였을 때, f(5)를 호출하였을 때 모두 f(2)가 같은 값이면 다이나믹으로 풀 수 있다.
 */
public class DynamicExample {

    private static final int NUM = 30;
    private static int[] memory = new int[NUM + 1];

    public static void main(String[] args) {
        System.out.println(fiboWithTopDown(NUM));
        System.out.println(fiboWithBottomUp(NUM));
    }

    private static int fiboWithBottomUp(int num) {
        memory[1] = 1;
        memory[2] = 1;

        for (int i = 3; i < num; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }

        return memory[num];
    }

    private static int fiboWithTopDown(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }

        if (memory[num] != 0) {
            return memory[num];
        }

        memory[num] = fiboWithTopDown(num - 1) + fiboWithTopDown(num - 2);
        return memory[num];
    }
}

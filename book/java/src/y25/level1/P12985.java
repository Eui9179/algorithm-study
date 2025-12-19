package y25.level1;

import java.util.Arrays;

public class P12985 {
    public static void main(String[] args) {
        System.out.println(new P12985().solution(8, 4, 7));
    }
    public int solution(int n, int a, int b) {
        int answer = 0;
        int round = n - 1;

        int[] tree = new int[(n * 2)];

        int j = n;
        for (int i = (n * 2) - 1; i > 0; i--) {
            tree[i] = j;
            j--;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == round) {
                round /= 2;
                answer++;
            }
            if ((tree[i * 2] == a && tree[i * 2 + 1] == b) || (tree[i * 2] == b && tree[i * 2 + 1] == a)) {
                break;
            }
            if (tree[i * 2] == a || tree[i * 2 + 1] == a) {
                tree[i] = a;
            } else if (tree[i * 2] == b || tree[i * 2 + 1] == b) {
                tree[i] = b;
            } else {
                tree[i] = tree[i * 2];
            }
        }

        return answer;
    }
}

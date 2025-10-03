package y24.implementations.practice;
import java.util.*;
public class P327 {
    public int solution(int[][] board, ArrayList<Tupple<Integer, Integer>> appleLocations, ArrayList<Tupple<Integer, String>> turns) {
        int timesIndex = 0;
        int currentA = 1, currentB = 1;
        int currentDir = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        ArrayList<Tupple<Integer, Integer>> snake = new ArrayList<>();

        board[currentA][currentB] = 1;
        snake.add(new Tupple<>(currentA, currentB));

        appleLocations.iterator().forEachRemaining(
                apple -> board[apple.a][apple.b] = 5
        );

        for (int time = 0; ; time++) {
            if (currentA == 0 || currentB == 0 || currentA == board.length || currentB == board.length) {
                return time;
            } else if (board[currentA][currentB] == 1 && time != 0) {
                return time;
            }

            if (board[currentA][currentB] == 5) {
                board[currentA][currentB] = 1;
                snake.add(new Tupple<>(currentA, currentB));
            } else if (board[currentA][currentB] == 0) {
                board[currentA][currentB] = 1;
                Tupple<Integer, Integer> tailPair = snake.remove(0);
                board[tailPair.a][tailPair.b] = 0;
                snake.add(new Tupple<>(currentA, currentB));
            }

            if (timesIndex < turns.size() && time == turns.get(timesIndex).a) {
                if (turns.get(timesIndex).b.equals("D")) {
                    currentDir++;
                    if (currentDir == 4) {
                        currentDir = 0;
                    }
                } else if (turns.get(timesIndex).b.equals("L")) {
                    currentDir--;
                    if (currentDir < 0) {
                        currentDir = 3;
                    }
                }
                timesIndex++;
            }
            currentA += dx[currentDir];
            currentB += dy[currentDir];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n+1][n+1];
        int k = sc.nextInt();

        int ax, ay, t;
        String d;

        ArrayList<Tupple<Integer, Integer>> appleLocations = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ax = sc.nextInt();
            ay = sc.nextInt();
            appleLocations.add(new Tupple<>(ax, ay));
        }

        int l = sc.nextInt();

        ArrayList<Tupple<Integer, String>> turns = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            t = sc.nextInt();
            d = sc.next();
            turns.add(new Tupple<>(t, d));
        }
        P327 main = new P327();
        System.out.println(main.solution(board, appleLocations, turns));
    }

    static class Tupple <T, V>{
        public T a;
        public V b;

        public Tupple(T a, V b) {
            this.a = a;
            this.b = b;
        }
    }
}

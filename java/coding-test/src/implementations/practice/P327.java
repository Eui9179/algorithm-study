package implementations.practice;
import java.util.*;
public class P327 {
    public int solution(int[][] board, int[][] appleLocations, int[] times, String[] directions) {
        int timesIndex = 0;
        int currentA = 1, currentB = 1;
        int[][] direction = new int[4][2];
        int currentDir = 0;

        ArrayList<Pair> snake = new ArrayList<>();

        direction[0][0] = 0;
        direction[0][1] = 1;

        direction[1][0] = 1;
        direction[1][1] = 0;

        direction[2][0] = 0;
        direction[2][1] = -1;

        direction[3][0] = -1;
        direction[3][1] = 0;

        board[currentA][currentB] = 1;
        snake.add(new Pair(currentA, currentB));

        for (int i = 0; i < appleLocations.length; i++) {
            board[appleLocations[i][0]][appleLocations[i][1]] = 5;
        }

        for (int time = 0; ; time++) {
            if (currentA == 0 || currentB == 0 || currentA == board.length || currentB == board.length) {
                return time;
            } else if (board[currentA][currentB] == 1 && time != 0) {
                return time;
            }

            if (board[currentA][currentB] == 5) {
                board[currentA][currentB] = 1;
                snake.add(new Pair(currentA, currentB));
            } else if (board[currentA][currentB] == 0) {
                board[currentA][currentB] = 1;
                Pair tailPair = snake.remove(0);
                board[tailPair.a][tailPair.b] = 0;
                snake.add(new Pair(currentA, currentB));
            }

            if (timesIndex < times.length && time == times[timesIndex]) {
                if (directions[timesIndex].equals("D")) {
                    currentDir++;
                    if (currentDir == 4) {
                        currentDir = 0;
                    }
                } else if (directions[timesIndex].equals("L")) {
                    currentDir--;
                    if (currentDir < 0) {
                        currentDir = 3;
                    }
                }
                timesIndex++;
            }
            currentA += direction[currentDir][0];
            currentB += direction[currentDir][1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n+1][n+1];
        int k = sc.nextInt();

        int ax, ay, t;
        String d;

        int[][] appleLocations = new int[k][2];

        for (int i = 0; i < k; i++) {
            ax = sc.nextInt();
            ay = sc.nextInt();
            appleLocations[i][0] = ax;
            appleLocations[i][1] = ay;
        }

        int l = sc.nextInt();

        int[] times = new int[l];
        String[] directions = new String[l];

        for (int i = 0; i < l; i++) {
            t = sc.nextInt();
            d = sc.next();
            times[i] = t;
            directions[i] = d;
        }
        P327 main = new P327();
        System.out.println(main.solution(board, appleLocations, times, directions));
    }

    class Pair {
        public int a;
        public int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}

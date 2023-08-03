package org.codingtest.softeer.p409;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        int blockCount = 0;
        List<Integer> answer = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = initMap(sc, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    answer.add(searchBlock(n, map, i, j));
                    blockCount++;
                }
            }
        }

        Collections.sort(answer);

        System.out.println(blockCount);
        answer.forEach(System.out::println);

    }

    public static int[][] initMap(Scanner sc, int n) {
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        return map;
    }

    public static int searchBlock(int n, int[][] map, int i, int j) {
        int result = 0;

        List<Point> queue = new ArrayList<>();
        int[][] step = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        queue.add(new Point(i, j));
        map[i][j] = -1;

        while (queue.size() > 0) {

            Point point = queue.remove(0);
            result++;

            for (int[] s : step) {
                int nextI = point.i + s[0];
                int nextJ = point.j + s[1];

                if (nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= n) {
                    continue;
                }

                if (map[nextI][nextJ] == -1 || map[nextI][nextJ] == 0) {
                    continue;
                }

                queue.add(new Point(nextI, nextJ));
                map[nextI][nextJ] = -1;
            }
        }
        return result;
    }

    public static class Point {
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
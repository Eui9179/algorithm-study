package org.codingtest.score_kit.p49190;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    static int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int[][] steps = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int solution(int[] arrows) {
        int answer = 0;
        int[] point = {0, 0};

        ArrayList<Integer> pointA = new ArrayList<>();
        ArrayList<Integer> pointB = new ArrayList<>();
        int pre = arrows[0];

        for (int arrow : arrows) {
            if (arrow != pre) {
                move(pre, point);
                pointA.add(point[0]);
                pointB.add(point[1]);
                pre = arrow;
            }
            for (int i = 0; i < 2; i++) {
                move(arrow, point);
                pointA.add(point[0]);
                pointB.add(point[1]);
            }
        }

        int maxA = Collections.max(pointA);
        int minA = Collections.min(pointA);

        int maxB = Collections.max(pointB);
        int minB = Collections.min(pointB);

        int height = maxA - minA;
        int width = maxB - minB;

        int[][] map = new int[height + 1][width + 1];

        for (int i = 0; i < pointA.size(); i++) {
            map[pointA.get(i) + Math.abs(minA)][pointB.get(i) + Math.abs(minB)] = 1;
        }

        for (int i = 0; i < height + 1; i++) {
            for (int j = 0; j < width + 1; j++) {
                if (map[i][j] == 0) {
                    if (searchFigure(map, i, j)) {
                        answer += 1;
                    }
                }
            }
        }

        return answer;
    }

    private boolean searchFigure(int[][] map, int i, int j) {
        int nextI, nextJ;
        boolean isFigure = true;

        ArrayList<int[]> history = new ArrayList<>();
        ArrayList<int[]> q = new ArrayList<>(Arrays.asList(new int[]{i, j}));

        while (q.size() > 0) {
            int[] node = q.remove(0);
            history.add(node);
            map[node[0]][node[1]] = isFigure ? 2 : 3;

            for (int[] step : steps) {
                nextI = node[0] + step[0];
                nextJ = node[1] + step[1];

                if (nextI < 0 || nextI >= map.length || nextJ < 0 || nextJ >= map[0].length) {
                    isFigure = false;
                    markNotFigure(map, history);
                }

                else if (map[nextI][nextJ] == 3) {
                    isFigure = false;
                    markNotFigure(map, history);
                }

                else if (map[nextI][nextJ] == 0) {
                    q.add(new int[]{nextI, nextJ});
                }
            }
        }

        return isFigure;
    }

    public void move(int direction, int[] point) {
        point[0] += directions[direction][0];
        point[1] += directions[direction][1];
    }


    public void print(int[][] map) {
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    public void markNotFigure(int[][] map, ArrayList<int[]> history) {
        for (int[] h : history) {
            map[h[0]][h[1]] = 3;
        }
    }

    static class Point {
        int a;
        int b;

        Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
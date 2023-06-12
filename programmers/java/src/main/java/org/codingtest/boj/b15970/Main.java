package org.codingtest.boj.b15970;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            int color = sc.nextInt();
            list.add(new Point(position, color));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            Point cur = list.get(i);

            int left = i - 1;
            int right =  i + 1;

            while (left >= 0) {
                if (list.get(left).color == cur.color) {
                    break;
                }
                left--;
            }

            while (right < n) {
                if (list.get(right).color == cur.color) {
                    break;
                }
                right++;
            }

            if (left < 0) {
                answer += list.get(right).position - cur.position;
            } else if (right >= n) {
                answer +=  cur.position - list.get(left).position;
            } else {
                answer += Math.min(list.get(right).position - cur.position, cur.position - list.get(left).position);
            }
        }

        System.out.println(answer);
    }

    static class Point implements Comparable<Point> {
        int position;
        int color;

        Point(int position, int color) {
            this.position = position;
            this.color = color;
        }

        @Override
        public int compareTo(Point point) {
            return this.position - point.position;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "position=" + position +
                    ", color=" + color +
                    '}';
        }
    }
}

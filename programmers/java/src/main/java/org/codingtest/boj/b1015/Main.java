package org.codingtest.boj.b1015;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e;
        Node[] A = new Node[n];
        for (int i = 0; i < n; i++) {
            e = sc.nextInt();
            A[i] = new Node(e, i);
        }
        pro(A, n);
    }

    static void pro(Node[] A, int n) {
        /*
        B[0] = A[2]
        B[0] = A[B[0].index]

        P[B[0].index] = 0;
        B[P[i]] = A[i]

        P[B[i].index] = i;
         */
        Arrays.sort(A);
        String[] P = new String[n];

        for (int i = 0; i < n; i++) {
            P[A[i].index] = String.valueOf(i);
        }

        System.out.println(String.join(" ", P));
    }

    static class Node implements Comparable<Node> {
        int num, index;

        Node(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Node node) {
            return this.num - node.num;
        }
    }
}

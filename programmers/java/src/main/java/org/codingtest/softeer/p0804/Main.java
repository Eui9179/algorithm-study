package org.codingtest.softeer.p0804;

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<Integer>> map = generateMap(sc, m);

        int s = sc.nextInt();
        int t = sc.nextInt();

        int[] set1 = getVisitedByDfs(map, n, s, t);
        int[] set2 = getVisitedByDfs(map, n, t, s);

        for (int i = 1; i < set1.length; i++) {
            if (i == s || i == t) continue;
            if (set1[i] == 1 && set2[i] == 1) answer++;
        }

        System.out.println(answer);
    }



    private static int[] getVisitedByDfs(Map<Integer, List<Integer>> map, int n, int s, int t) {
        List<Integer> stack = new ArrayList<>();
        int[] visited = new int[n + 1];

        stack.add(s);

        while (stack.size() > 0) {
            Integer node = stack.remove(stack.size() - 1);

            if (node.equals(t)) {
                continue;
            }

            if (visited[node] == 1) {
                continue;
            }

            visited[node] = 1;

            stack.addAll(map.get(node));
        }

        return visited;
    }

    private static Map<Integer, List<Integer>> generateMap(Scanner sc, int m) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int s;
        int t;

        for (int i = 0; i < m; i++) {
            s = sc.nextInt();
            t = sc.nextInt();

            if (map.containsKey(s)) {
                map.get(s).add(t);
            } else {
                map.put(s, new ArrayList<>(List.of(t)));
            }
        }
        return map;
    }
}
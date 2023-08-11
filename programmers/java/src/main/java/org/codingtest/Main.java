package org.codingtest;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
        Scanner scanner = new Scanner(System.in);

        list.remove(1);

        StringBuilder sb = new StringBuilder();


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int target = sc.nextInt();

            map.put(
                    start,
                    map.getOrDefault(start, new ArrayList<>(List.of(target)))
            );
        }
    }
}

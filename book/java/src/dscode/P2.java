package dscode;

import java.util.*;

public class P2 {
    public static void main(String[] args) {
        System.out.println(solution("IPYIYP", 3));
        System.out.println(solution("IY", 1));
        System.out.println(solution("PPY", 2));

    }

    public static int solution(String bears, int k) {
        int answer = -1;

        Queue<String> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(bears);
        depth.add(0);
        visited.add(bears);

        String target = "I".repeat(bears.length());

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int d = depth.poll();

            if (current.equals(target)) return d;

            for (int i = 0; i <= bears.length() - k; i++) {
                String next = changeColor(current, i, k);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                    depth.add(d + 1);
                }
            }
        }

        return answer;
    }

    private static String changeColor(String jellyColor, int start, int k) {
        char[] arr = jellyColor.toCharArray();
        for (int i = start; i < start + k && i < arr.length; i++) {
            if (arr[i] == 'Y') arr[i] = 'P';
            else if (arr[i] == 'P') arr[i] = 'I';
            else arr[i] = 'Y';
        }
        return String.valueOf(arr);
    }

}

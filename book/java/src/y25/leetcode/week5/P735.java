package y25.leetcode.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P735 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P735().asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(new P735().asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(new P735().asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(new P735().asteroidCollision(new int[]{3, 5, -6, 2, -1, 4})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();

        for (int a : asteroids) {
            boolean isDistroied = false;
            if (a > 0) {
                while (!stack.isEmpty() &&
                        stack.get(stack.size() - 1) < 0 &&
                        Math.abs(stack.get(stack.size() - 1)) <= a
                ) {
                    int remove = stack.remove(stack.size() - 1);
                    if (remove == a) {
                        isDistroied = true;
                        break;
                    }
                }
                if (!stack.isEmpty() && Math.abs(stack.get(stack.size() - 1)) > a) {
                    isDistroied = true;
                }
            } else {
                while (!stack.isEmpty() &&
                        stack.get(stack.size() - 1) > 0 &&
                        stack.get(stack.size() - 1) <= Math.abs(a)
                ) {
                    int remove = stack.remove(stack.size() - 1);
                    if (remove == Math.abs(a)) {
                        isDistroied = true;
                        break;
                    }
                }
                if (!stack.isEmpty() && stack.get(stack.size() - 1) > Math.abs(a)) {
                    isDistroied = true;
                }
            }
            if (!isDistroied) stack.add(a);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

}

package y25.greedy;

import java.util.ArrayList;
import java.util.List;

public class P317 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2}, 10));
    }

    private static int solution(int[] foodTimes, int k) {
        List<Food> foodList = new ArrayList<>();
//        Queue<Food> q = new PriorityQueue<>();
        for (int i = 0; i < foodTimes.length; i++) {
            Food food = new Food(i, foodTimes[i]);
//            q.add(food);
            foodList.add(food);
        }
//
//        while (!q.isEmpty() && !foodList.isEmpty()) {
//            Food min = q.poll();
//            int decreaseValue = min.value;
//            int processCount = decreaseValue * foodList.size();
//            if (processCount <= k) {
//                foodList = foodList.stream()
//                        .map(food -> food.decreaseValue(decreaseValue))
//                        .filter(food -> food.value > 0)
//                        .collect(Collectors.toList());
//                k -= processCount;
//            } else {
//                break;
//            }
//        }
//
//        if (k == 0) {
//            return foodList.get(0).value > 0 ? 1: -1;
//        }
//
        while (k > 0) {
            boolean isBreak = true;
            for (Food f : foodList) {
                if (f.value != 0) {
                    isBreak = false;
                    break;
                }
            }
            if (isBreak) break;

            for (int i = 0; i < foodList.size(); i++) {
                if (foodList.get(i).value > 0) {
                    foodList.get(i).decreaseValue(1);
                    k--;
                }

                if (k == 0) {
                    if (i == foodList.size() - 1) {
                        if (foodList.get(0).value == 0) return -1;
                        return foodList.get(0).index;
                    }
                    if (foodList.get(i + 1).value == 0) return -1;
                    return foodList.get(i + 1).index;
                }
            }

        }


        return -1;
    }

    static class Food implements Comparable<Food> {
        int index;
        int value;

        public Food(int index, int value) {
            this.index = index + 1;
            this.value = value;
        }

        @Override
        public int compareTo(Food food) {
            return this.value - food.value;
        }

        public Food decreaseValue(int value) {
            this.value = this.value - value;
            return this;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }
}

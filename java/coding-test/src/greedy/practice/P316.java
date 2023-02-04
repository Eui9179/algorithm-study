package greedy.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P316{
    public int solution(int[] food_times, long k) {
        /**
         * 뺀 값 저장
         * 1. 0제거
         * 2. if k/food_times > 0 최소값으로 배열 전체 뺌
         * 2-1.     k -= 배열 개수
         * 3. else 남은 k개 만큼 이동하고 뺀 값 만큼 또뺌  0보다 크면 return -> 반복
         *
         *
         * 1. 전체 얼마를 뺌?
         * 2. 몇바퀴?
         */
        /**
         * 못품
         */

        int answer = 0;
        int subNum = 0;
        int sn, minNum;
        long cycle;

        ArrayList<Integer> foodTimes = new ArrayList<>();
        for (int food_time: food_times) {
            foodTimes.add(food_time);
        }


        while (true) {
            foodTimes.removeAll(Arrays.asList(Integer.valueOf(0)));
            cycle = k - foodTimes.size();
            if (cycle > 0) {
                k -= foodTimes.size();
                minNum = Collections.min(foodTimes);
                subNum += minNum;
                for (int i = 0; i < foodTimes.size(); i++) {
                    sn = foodTimes.get(i) - minNum;
                    if (sn < 0) {
                        foodTimes.set(i, 0);
                    } else {
                        foodTimes.set(i, sn);
                    }
                }
            } else {
                break;
            }
        }

        int i = 0;
        while (i < k) {
            if (food_times[i] - subNum > 0) {
                return i + 1;
            } else {
                i++;
            }
        }
        return -1;


//        int time = 0;
//
//        while (time < k) {
//            if (food_times[answer] > 0) {
//                food_times[answer]--;
//                time++;
//            }
//            answer++;
//            if (answer == food_times.length) {
//                answer = 0;
//            }
//        }
////        if (Arrays.stream(food_times).sum() == 0) {
////            return -1;
////        }
//        for (int i = answer; i < food_times.length; i++) {
//            if (food_times[i] != 0) {
//                return i+1;
//            }
//        }
//        return -1;
//        return answer;
    }

    public static void main(String[] args) {
        P316 p = new P316();
//        int[] foodTimes = {1, 3, 2};
//        int[] foodTimes = {3,1,1,1,2,4,3};
//        int[] foodTimes = {4, 1, 1, 5};
        int[] food_times = {1, 1, 0, 1, 0, 1};

        int k = 4;
//        System.out.println(p.solution(foodTimes, k));

        ArrayList<Integer> foodTimes = new ArrayList<>();
        for (int food_time : food_times) {
            foodTimes.add(food_time);
        }

        foodTimes.removeAll(Arrays.asList(Integer.valueOf(0)));
        System.out.println("foodTimes = " + foodTimes);
    }

}

//    int count = (int)(k / food_times.length);
//        int minTime = Arrays.stream(food_times).min().getAsInt();
//        k -= food_times.length;
//
//
//        if (count >= minTime) {
//            for (int i = 0; i < food_times.length; i++) {
//                food_times[i] -= minTime;
//            }
//        }
//
//        //출력
////        for (int i = 0; i < food_times.length; i++) {
////            System.out.print(food_times[i]);
////        }
////        System.out.println();
//
//        int time = 0;
//        while (time <= k) {
//            if (Arrays.stream(food_times).sum() == 0) {
//                return -1;
//            }
//            if (food_times[answer] > 0) {
//                food_times[answer]--;
//                time++;
//            }
//            answer++;
//            if (answer == food_times.length) {
//                answer = 0;
//            }
//        }

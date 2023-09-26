package org.codingtest.inflearn.ds.p3_2;

import java.util.*;

class Solution {
    public int[] solution(int[] arrival, int[] state) {
        int[] answer = new int[arrival.length];
        int time = 0;
        int status = 1;

        List<InAndOut> inQueue = new ArrayList<>();
        List<InAndOut> outQueue = new ArrayList<>();

        for (int i = 0; i < arrival.length; i++) {
            if (state[i] == 1) {
                outQueue.add(new InAndOut(i, arrival[i]));
            } else {
                inQueue.add(new InAndOut(i, arrival[i]));
            }
        }

        int i = 0;
        while (i < arrival.length) {
            int j = i;
            while (j < arrival.length && arrival[j] <= time) {

                if (state[j] == 1) {
                    outQueue.add(new InAndOut(i, arrival[i]));
                } else {
                    inQueue.add(new InAndOut(i, arrival[i]));
                }
                j++;
            }
            if (status == 1) {
                if (!outQueue.isEmpty() && outQueue.get(0).time <= time) {
                    answer[outQueue.get(0).index] = time;
                    outQueue.remove(0);
                    time++;
                    i++;
                    continue;
                }
                status = 0;
                if (status == 0) {
                    if (!inQueue.isEmpty() && inQueue.get(0).time <= time) {
                        answer[inQueue.get(0).index] = time;
                        inQueue.remove(0);
                        time++;
                        i++;
                        continue;
                    }
                    status = 1;
                }
            } else {
                if (!inQueue.isEmpty() && inQueue.get(0).time <= time) {
                    answer[inQueue.get(0).index] = time;
                    inQueue.remove(0);
                    time++;
                    i++;
                    continue;
                }
                status = 1;
                if (status == 1) {
                    if (!outQueue.isEmpty() && outQueue.get(0).time <= time) {
                        answer[outQueue.get(0).index] = time;
                        outQueue.remove(0);
                        time++;
                        i++;
                        continue;
                    }
                }
            }
            time++;
        }

        return answer;
        // 임시 큐
        /* 3-1, 3-0, 4-1, 5-0, 5-1, 5-0
         * in: [5-0, 5-0]
         * out: []
         * status: 1 or 0 (default in)
         * time: 7
         * status: 0
         * result: [3-1, ]
         *
         * 현재 time과 같은 애 + status가 같으면 삽입
         * 1초동안 들어온 애가 없으면 status 1로 초기화
         * out이 비어있거나, 현재 시간보다 낮은 애가 없다면 status 0
         * result 마지막과 시간이 1초차이라면 status가 같은 애 출력
         *
         *
         * -1초에 없다면 같은 애 중에 결정
         * result의 최근 애와 비교(시간 1초 차이 + 상태 같음)
         */

    }

    static class InAndOut {
        int index;
        int time;

        InAndOut(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public String toString() {
            return "{" +
                    "index=" + index +
                    ", time=" + time +
                    '}';
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}

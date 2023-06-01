package org.codingtest.level2.p42626;

import java.util.*;

class Solution {
    public boolean check(PriorityQueue<Integer> q, int k) {
        for (Integer e : q) {
            if (e < k) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        int fir, sec, sum;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int sco : scoville) {
            if (sco >= K) continue;
            q.add(sco);
        }

        while (q.size() > 1 && !check(q, K)) {
            fir = q.poll();
            sec = q.poll();

            sum = fir + (sec * 2);
            q.add(sum);

            answer++;
        }

        return check(q, K) ? answer : -1;
    }
}
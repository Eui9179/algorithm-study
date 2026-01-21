package y25.leetcode.week2;

import java.util.PriorityQueue;

public class Longest_Consecutive_Sequence_128 {
    static class Solution {
        public int longestConsecutive(int[] nums) {
            int answer = 1;

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.offer(num);
            }

            if (queue.isEmpty()) return 0;

            int current = queue.poll();
            int count = 1;

            while (!queue.isEmpty()) {
                int value = queue.poll();
                if (current + 1 == value) {
                    count++;
                } else if (current + 1 < value) {
                    answer = Math.max(answer, count);
                    count = 1;
                }
                current = value;
            }
            return Math.max(answer, count);
        }
    }
}

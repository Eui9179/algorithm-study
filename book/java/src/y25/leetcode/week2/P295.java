package y25.leetcode.week2;

import java.util.PriorityQueue;

public class P295 {
    class MedianFinder {

        PriorityQueue<Integer> queue1 = new PriorityQueue<>((i1, i2) -> i2 - i1);
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();

        public MedianFinder() {}

        public void addNum(int num) {
            if (queue1.isEmpty() || num <= queue1.peek()) {
                queue1.add(num);
            } else if (num > queue1.peek()) {
                queue2.add(num);
            }

            if (queue2.size() > queue1.size()) {
                queue1.offer(queue2.poll());
            } else if (queue1.size() - 1 > queue2.size()) {
                queue2.offer(queue1.poll());
            }
        }

        public double findMedian() {
            if (queue1.size() == queue2.size()) {
                return (((double) queue1.peek()) + ((double) queue2.peek())) / 2;
            }
            return queue1.peek();
        }
    }
}

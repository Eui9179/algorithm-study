package org.codingtest.inflearn.ds.p4;

import java.util.*;

class Solution {
    public int solution(int[] laser, String[] enter) {
        int answer = 0;

        PriorityQueue<Node> outQueue = new PriorityQueue<>();

        String[] eSplit = enter[0].split(" ");
        String[] timeSplit = eSplit[0].split(":");
        int laserKind = Integer.parseInt(eSplit[1]);
        int startTime = (Integer.parseInt(timeSplit[0]) * 60) + Integer.parseInt(timeSplit[1]);
        int endTime = startTime + laser[laserKind];
        outQueue.add(new Node(0, endTime));

        int i = 1;

        while (i < enter.length && !outQueue.isEmpty()) {

            eSplit = enter[i].split(" ");
            timeSplit = eSplit[0].split(":");
            laserKind = Integer.parseInt(eSplit[1]);
            startTime = (Integer.parseInt(timeSplit[0]) * 60) + Integer.parseInt(timeSplit[1]);
            while (!outQueue.isEmpty() && outQueue.peek().time <= startTime) {
                outQueue.poll();
                answer = Math.max(answer, outQueue.size());
            }

            endTime = startTime + laser[laserKind];
            outQueue.add(new Node(i, endTime));
            i++;
        }


        while (!outQueue.isEmpty()) {
            outQueue.poll();
            answer = Math.max(answer, outQueue.size());
        }
        System.out.println();

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }

    static class Node implements Comparable<Node> {
        int index;
        int time;

        Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Node node) {
            if (this.time == node.time) {
                return this.index - node.index;
            }
            return this.time - node.time;
        }

        @Override
        public String toString() {
            return "{" +
                    "index=" + index +
                    ", time=" + time +
                    '}';
        }
    }
}
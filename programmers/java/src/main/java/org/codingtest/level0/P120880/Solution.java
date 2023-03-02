package org.codingtest.level0.P120880;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Number[] clone = new Number[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            clone[i] = new Number(i, numlist[i], n);
        }

        Arrays.sort(clone);

        return Arrays.stream(clone).mapToInt(c -> c.ori).toArray();
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 3, 4, 5, 6}, 4);
    }

    static class Number implements Comparable<Number> {
        public int index;
        public int ori;
        public int number;

        public Number(int index, int number, int n) {
            this.index = index;
            this.ori = number;
            this.number = Math.abs(number - n);
        }

        @Override
        public int compareTo(Number number) {
            if (this.number == number.number) {
                return number.ori - this.ori;
            }
            return this.number - number.number;
        }

        @Override
        public String toString() {
            return "index " + index + " " + number;
        }
    }
}
package org.codingtest.score_kit.exhausivesearch.p42839;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("17"));
        System.out.println(new Solution().solution("011"));
    }

    public int solution(String numbers) {
        int answer = 0;
        int[] numberArray = separateNumbers(numbers);
        for (int i = 1; i <= numbers.length(); i++) {
            Set<Integer> comb = generateCombinations(numberArray, i);
            for (int c : comb) {
                if (isPrime(c)) answer++;
            }
        }
        return answer;
    }

    private boolean isPrime(int num) {
        if (num == 1 || num == 0) return false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] separateNumbers(String numbers) {
        return Arrays.stream(numbers.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private Set<Integer> generateCombinations(int[] numbers, int r) {
        Set<Integer> combinationSet = new HashSet<>();
        int[] output = new int[r];
        boolean[] visited = new boolean[numbers.length];
        perm(combinationSet, numbers, output, visited, 0, r);
        return combinationSet;
    }

    private void perm(Set<Integer> set, int[] numbers, int[] output, boolean[] visited, int index, int r) {
        if (index == r) {
            StringBuilder result = new StringBuilder();
            for (int o : output) result.append(o);

            String num = result.toString();
            if (!num.startsWith("0")) {
                set.add(Integer.parseInt(num));
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) continue;
            output[index] = numbers[i];
            visited[i] = true;
            perm(set, numbers, output, visited, index + 1, r);
            visited[i] = false;
        }
    }
}
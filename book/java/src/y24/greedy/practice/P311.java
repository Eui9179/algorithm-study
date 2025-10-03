package y24.greedy.practice;

import java.util.Arrays;

public class P311 {
    public int solution(int n, int[] people) {
        int answer = 0;

        Arrays.sort(people);
        for (int i = 0; i < n;) {
            i += people[i];
            if (i <= n) {
                answer++;
            }
        }
        return answer;
    }
}

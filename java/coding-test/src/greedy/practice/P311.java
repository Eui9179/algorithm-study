package greedy.practice;

import java.util.Arrays;
import java.util.Scanner;

public class P311 {
    public static int solution(int n, int[] people) {
        int answer = 0;
        Arrays.sort(people);

        int index = 0;
        while (index < n) {
            index += people[index];
            answer += 1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] people = new int[n];

        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }

        System.out.println(solution(n, people));


    }
}

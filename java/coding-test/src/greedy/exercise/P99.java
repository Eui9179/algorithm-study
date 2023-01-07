/*1이 될 때까지*/
package greedy.exercise;

public class P99 {
    public static void solution(int num, int k) {
        int answer = 0;
        while(num != 1) {
            num = num % k != 0 ? num - 1 : num / k;
            answer ++;
        }
        System.out.println("answer = " + answer);

    }
    public static void main(String[] args) {
        solution(25, 5);
    }
}

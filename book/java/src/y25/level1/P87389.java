package y25.level1;

public class P87389 {
    public int solution(int n) {
        int answer = 0;

        // n을 나눠서 1이되는 가장 작은 자연수
        int i = 2;
        while (n % i == 1) {
            i++;
        }

        return answer;
    }
}

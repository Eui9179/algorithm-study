package y25.level1;

public class P132267 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int count = (n / a) * b;
            int remain = n % a;
            answer += count;
            n = count + remain;
        }

        return answer;
    }
}

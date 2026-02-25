package y25.book.ch1;

public class P04_3 {

    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    private static int solution(int target) {
        int answer = 0;
        int s = 0, e = 1;

        int[] arr = new int[target];
        for (int i = 1; i <= target; i++) {
            arr[i - 1] = i;
        }

        int current = arr[s];

        while (e < arr.length) {
            while (current < target && e < arr.length) {
                current += arr[e++];
            }

            while (current > target && s < e) {
                current -= arr[s++];
            }

            if (current == target) {
                answer++;
                current -= arr[s++];
            }
        }

        return answer;
    }

}

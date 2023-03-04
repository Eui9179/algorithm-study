package greedy.practice;

class P316 {
    public int solution2(int[] food_times, long k) {
        int answer = 0;

        for (int i = 0; i < k + 1;) {
            if (answer == food_times.length) {
                answer = 0;
            }
            if (food_times[answer] == 0) {
                answer++;
            } else {
                food_times[answer]--;
                i++;
                answer++;
            }
        }
        return answer;
    }
}

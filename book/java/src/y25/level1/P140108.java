package y25.level1;

public class P140108 {
    public int solution(String s) {
        int answer = 0;

        int xCount = 0;
        int otherCount = 0;

        String[] split = s.split("");
        String x = null;

        for (int i = 0; i < split.length; i++) {
            if (x == null) {
                x = split[i];
            }

            if (x.equals(split[i])) {
                xCount++;
            } else {
                otherCount++;
            }

            if (xCount == otherCount) {
                answer++;
                xCount = 0;
                otherCount = 0;
                x = null;
            }
        }

        if (xCount != 0) answer++;

        return answer;
    }
}

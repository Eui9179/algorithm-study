package y25.level1;

public class P147355 {
    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            long num = Long.parseLong(t.substring(i, i + p.length()));
            if (num <= Long.parseLong(p)) {
                answer++;
            }
        }

        return answer;
    }
}

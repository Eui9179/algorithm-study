package y25.level1;

public class P213 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int i1 = 0, i2 = 0, g = 0;

        while (g < goal.length) {
            if (i1 < cards1.length && cards1[i1].equals(goal[g])) {
                i1++;
                g++;
            } else if (i2 < cards2.length && cards2[i2].equals(goal[g])) {
                i2++;
                g++;
            } else {
                return "no";
            }
        }
        return answer;
    }
}

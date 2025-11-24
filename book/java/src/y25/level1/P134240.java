package y25.level1;

public class P134240 {
    public String solution(int[] food) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb1.append(i);
                sb2.append(i);
            }
        }

        sb1.append("0");

        return sb1.toString() + sb2.reverse().toString();
    }
}

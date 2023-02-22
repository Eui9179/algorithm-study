package level0;

public class P120816 {
    public static int solution(int slice, int n) {
        // 7조각이라면?
        return n / 7 + ((n % slice != 0) ? 1: 0);
    }
    public static void main(String[] args) {

    }
}

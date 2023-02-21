package level0;

public class P120822 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("hello"));
    }
}

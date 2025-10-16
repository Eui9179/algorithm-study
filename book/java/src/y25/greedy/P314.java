package y25.greedy;

public class P314 {
    public static void main(String[] args) {
        System.out.println(solution("0001100"));
        System.out.println(solution("1111111111"));
        System.out.println(solution("0101010"));
        System.out.println(solution("00001"));
    }

    private static int solution(String str) {
        int count0 = 0, count1 = 0;
        char current = str.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            if (current != str.charAt(i)) {
                if (current == '0') {
                    count0++;
                } else {
                    count1++;
                }
                current = str.charAt(i);
            }
        }

        return ((count0 == 0 && count1 == 1) || (count0 == 1 && count1 == 0)) ?
                1 :
                Math.min(count0, count1);
    }
}

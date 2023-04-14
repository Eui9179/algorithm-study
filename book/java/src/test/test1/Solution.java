package test.test1;

public class Solution {

    public int solution(String number) {
        int answer = 0;

        String[] split = number.split("");
        String input;
        boolean is = false;

        for (int i = 0; i < split.length; i++) {
            if (is) {
                is = false;
                continue;
            }
            answer++;
            if (split[i].equals("0")) {
                continue;
            }
            input = error(split[i]);
            String errorText = input.substring(1, 2);

            if (i == split.length - 1) {
                answer += 1;
                break;
            }

            if (split[i + 1].equals(errorText)) {
                is = true;
            } else {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;

    }

    public String error(String num) {
        return num + (Integer.parseInt(num) + 1);
    }

    public static void main(String[] args) {
        new Solution().solution("100");
    }

}

package implementations.practice;

import java.util.ArrayList;

public class P323 {
    public static int solution(String s) {
        int answer = 1001; // s 길이의 최대값
        int halfLength = s.length() / 2; // 절반 길이
        int sCount, intLength; //임시 글자 개수, 반복된 글자 개수의 문자 길이
        String compStr; //비교할 글자
        ArrayList<Integer> resultArray = new ArrayList<>();//결과 배열

        for (int comp = 1; comp <= halfLength; comp++) {
            String str = s.substring(0, comp); //처음 글자
            resultArray.add(0, 1); //최종 배열에 첫번째 글자 입력
            for (int i = comp; i < s.length(); i+=comp) {
                if (i + comp > s.length()) break; //비교할 글자 길이가 전체 길이를 넘었을 때

                compStr = s.substring(i, i + comp);//비교할 글자
                if (str.equals(compStr)) {
                    sCount = resultArray.get(0);
                    resultArray.set(0, ++sCount); //같다면 현재 글자 수 추가
                } else {
                    str = compStr; //다르면 현재 글자 바꿔주고
                    resultArray.add(0, 1); //다음 글자 수 개수 셀 준비
                }
            }

            int compCount = s.length(); //글자 전체 길이
            for (int num: resultArray) {
                if (num != 1) { //1은 무시
                    compCount -= (comp * (num - 1)); //중복된 글자 하나만 남기기
                    intLength = (int) (Math.log10(num) + 1); //중복된 글자 개수의 자리수 구하기
                    compCount += intLength; //자리수 만큼 글자 추가
                }
            }
            answer = Math.min(answer, compCount); //최소값
            resultArray.clear(); //다음 글자 수
        }
        if (answer == 1001) { //한글자도 안 바뀌었다면
            return s.length();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aaaaaaaaabaa"));
        // a
        // aaaaaaaaaaaaab
    }
}

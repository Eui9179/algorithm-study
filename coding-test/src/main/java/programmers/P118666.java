package programmers;

import java.util.Arrays;
import java.util.List;

public class P118666 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] personality = {"R", "T", "C", "F", "J", "M", "A", "N"};
        List pArrays = Arrays.asList(personality);
        int[] score = new int[8];

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                String stringAt = String.valueOf(survey[i].charAt(0));
                int indexof = pArrays.indexOf(stringAt);
                score[indexof] += (4 - choices[i]);
            } else if (choices[i] > 4) {
                String stringAt = String.valueOf(survey[i].charAt(1));
                int indexof = pArrays.indexOf(stringAt);
                score[indexof] += (choices[i] - 4);
            }
        }
        if (score[0] < score[1]){
            answer += personality[1];
        } else {
            answer += personality[0];
        }
        if (score[2] < score[3]){
            answer += personality[3];
        } else {
            answer += personality[2];
        }
        if (score[4] < score[5]){
            answer += personality[5];
        } else {
            answer += personality[4];
        }
        if (score[6] < score[7]){
            answer += personality[7];
        } else {
            answer += personality[6];
        }
        return answer;
    }
}

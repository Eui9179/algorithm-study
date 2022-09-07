package level1;

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
                score[pArrays.indexOf(stringAt)] += (4 - choices[i]);
            } else if (choices[i] > 4) {
                String stringAt = String.valueOf(survey[i].charAt(1));
                score[pArrays.indexOf(stringAt)] += (choices[i] - 4);
            }
        }

        for (int i=0; i<score.length-1; i+=2){
            if(score[i]< score[i+1]){
                answer += personality[i+1];
            } else {
                answer += personality[i];
            }
        }

        return answer;
    }
}

import programmers.P118666;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) {
        P118666 p118666 = new P118666();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String result = p118666.solution(survey, choices);
        System.out.println(result);
    }
}

package org.codingtest.softeer.p77;
import java.util.*;
import java.io.*;



public class Main
{
    public static Map<Integer, List<Integer>> sevenSegmentMap = Map.of(
            0, List.of(1, 1, 1, 0, 1, 1, 1),
            1, List.of(0, 0, 0, 0, 0, 1, 1),
            2, List.of(0, 1, 1, 1, 1, 1, 0),
            3, List.of(0, 0, 1, 1, 1, 1, 1),
            4, List.of(1, 0, 0, 1, 0, 1, 1),
            5, List.of(1, 0, 1, 1, 1, 0, 1),
            6, List.of(1, 1, 1, 1, 1, 0, 1),
            7, List.of(1, 0, 1, 0, 0, 1, 1),
            8, List.of(1, 1, 1, 1, 1, 1, 1),
            9, List.of(1, 0, 1, 1, 1, 1, 1)
    );

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int answer = 0;

            String originNumStr = fillZero(sc.next());
            String newNumStr = fillZero(sc.next());

            for (int j = 0; j < 5; j++) {
                answer += getModifiedCount(originNumStr.charAt(j), newNumStr.charAt(j));
            }

            System.out.println(answer);
        }
    }

    private static String fillZero(String number) {
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 5 - number.length()) {
            sb.append("-");
        }
        sb.append(number);
        return sb.toString();
    }

    private static int getModifiedCount(char originNumberChar, char newNumberChar) {
        int result = 0;

        List<Integer> origin7Segment = originNumberChar == '-' ?
                List.of(0, 0, 0, 0, 0, 0, 0):
                sevenSegmentMap.get(originNumberChar - '0');

        List<Integer> new7Segment = originNumberChar == '-' ?
                List.of(0, 0, 0, 0, 0, 0, 0):
                sevenSegmentMap.get(newNumberChar - '0');

        System.out.println(origin7Segment);
        System.out.println(new7Segment);

        for (int i = 0; i < 7; i++) {
            if (!origin7Segment.get(i).equals(new7Segment.get(i))) {
                result++;
            }
        }

        return result;
    }
}


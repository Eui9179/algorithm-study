package org.codingtest.c.test;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        char[] array = new char[800_000];
        String s = "c";
        // 반복문을 이용한 데이터 입력

        for (int i = 0; i < 800_000; i++) {
            array[i] = s.charAt(0);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("##실행시간(초.0f) : " + (endTime - startTime) / 1000.0f + "초");
    }
}

package org.codingtest;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(Arrays.asList("hello", "world"));
        String[] array = arrayList.toArray(String[]::new);




    }
}